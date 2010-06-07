/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class FullscreenGlassPane extends JPanel {

    private static final int reminderTicks = 100;
    private int displayReminder = reminderTicks;
    private static final String reminderString = "Press ESC to exit fullscreen";
    private static final Font font = new Font("Dialog", Font.PLAIN, 50);
    private static final Image cursorImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);

    public FullscreenGlassPane() {
        MovementListener movementListener = new MovementListener();
        addMouseListener(movementListener);
        addMouseMotionListener(movementListener);

        addKeyListener(new EscListener());
        setOpaque(false);

        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(), "clear cursor"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // if the mouse has been moved within the timeout
        // draw a rounded rectangle with a message "press ESC to exit fullscreen"

        int screenWidth = getWidth();
        int screenHeight = getHeight();

        if (displayReminder <= 0) {
            return;
        }

        g.setFont(font);
        Rectangle2D stringBounds = g.getFontMetrics().getStringBounds(reminderString, g);

        int textWidth = (int) stringBounds.getWidth();
        int textHeight = (int) stringBounds.getHeight();

        int width = 100 + textWidth;
        int height = 100 + textHeight;
        int roundness = 50;

        int alpha = 255 * displayReminder / reminderTicks;
        g.setColor(new Color(200, 200, 200, alpha));
        g.fillRoundRect(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height, roundness, roundness);

        g.setColor(new Color(0, 0, 0, alpha));
        int textx = screenWidth / 2 - textWidth / 2;
        int texty = screenHeight / 2 + textHeight / 3;
        g.drawString(reminderString, textx, texty);

        displayReminder--;
        repaint();
    }

    private class MovementListener extends MouseAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {
            displayReminder = reminderTicks;
            repaint();
        }
    }

    private class EscListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                PainterView.getInstance().toggleFullscreen();
            }
        }
    }
}
