/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview.valueview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.border.LineBorder;
import utils.curves.CurveUtil;
import utils.curves.CurveUtil.Curve_col;

/**
 *
 * @author Calvin Ashmore
 */
public class Curve_colView extends ValueView<CurveUtil.Curve_col> {

    public Curve_colView(Curve_col value) {
        super(value);

        setPreferredSize(new Dimension(200, 50));
        setBorder(new LineBorder(Color.BLACK));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < getWidth(); i++) {
            double t = 1.0 * i / (getWidth() - 1);
            g.setColor(new Color(getValue().getValue(t).toARGB()));
            g.drawLine(i, 0, i, getHeight());
        }
    }
}
