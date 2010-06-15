/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview.valueview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import utils.curves.CurveUtil;
import utils.curves.CurveUtil.Curve_d;

/**
 *
 * @author Calvin Ashmore
 */
public class Curve_dView extends ValueView<CurveUtil.Curve_d> {

    private static final int SAMPLES = 200;

    public Curve_dView(Curve_d value) {
        super(value);

        setPreferredSize(new Dimension(200, 50));
    }
    private double[] values = null;
    private double minValue;
    private double maxValue;

    private void fillData() {

        values = new double[SAMPLES];
        minValue = Double.MAX_VALUE;
        maxValue = -Double.MAX_VALUE;
        for (int i = 0; i < SAMPLES; i++) {
            double t = 1.0 * i / (SAMPLES - 1);
            double sample = getValue().getValue(t).val;
            if (minValue > sample) {
                minValue = sample;
            }
            if (maxValue < sample) {
                maxValue = sample;
            }
            values[i] = sample;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (values == null) {
            fillData();
        }

        g.setColor(Color.BLACK);
        for (int i = 0; i < SAMPLES - 1; i++) {

            double t1 = 1.0 * i / (SAMPLES - 1);
            double t2 = 1.0 * (i + 1) / (SAMPLES - 1);

            int x1 = (int) (t1 * getWidth());
            int x2 = (int) (t2 * getWidth());
            int y1 = (int) ((1 - (values[i] - minValue) / (maxValue - minValue)) * getHeight());
            int y2 = (int) ((1 - (values[i + 1] - minValue) / (maxValue - minValue)) * getHeight());
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
