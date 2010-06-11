package painter.app.ui.genview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

class CirclePanel extends JPanel {

    public static final int circleWidth = 10;
    protected static Color circleColor = new Color(80, 80, 80);
    protected static Color circleFill = new Color(200, 200, 200);
    private final VisualNode visualNode;
    private final boolean isOutput;
    private final int index;

//    private boolean entered;
    boolean getIsOutput() {
        return isOutput;
    }

    int getIndex() {
        return index;
    }

    public CirclePanel(VisualNode visualNode, boolean isOutput, int index) {
        this.visualNode = visualNode;
        this.isOutput = isOutput;
        this.index = index;

        setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(circleWidth + 1, circleWidth + 1);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(circleWidth + 1, circleWidth + 1);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(circleWidth + 1, circleWidth + 1);
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(circleColor);
        g.drawOval(0, 0, circleWidth, circleWidth);

        g.setColor(circleFill);
        g.fillOval(2, 2, circleWidth - 3, circleWidth - 3);
    }
}
