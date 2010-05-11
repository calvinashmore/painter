/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.linear.grid;

import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class BlurTool {


    public static Buffer_d scaleBuffer(Buffer_d buffer, int newRes) {
        return scaleBuffer(buffer, newRes, newRes);
    }

    /**
     * Scales to newResolution using square scaling.
     * Creates a new buffer.
     * @param buffer
     * @param newResolution
     * @return
     */
    public static Buffer_d scaleBuffer(Buffer_d buffer, int newWidth, int newHeight) {
        int oldWidth = buffer.getXRes();
        int oldHeight = buffer.getYRes();
        Buffer_d newBuffer = new Buffer_d(newWidth, newHeight);
        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                int xOld = x * oldWidth / newWidth;
                int yOld = y * oldHeight / newHeight;
                LDouble value = buffer.getValue(xOld, yOld);
                newBuffer.setValue(x, y, value);
            }
        }
        return newBuffer;
    }

    public BlurTool(double sharpness) {
        this.sharpness = sharpness;
    }
    private double sharpness;

    public Buffer_d process(Buffer_d gridIn, int steps) {

        Buffer_d gridOut = new Buffer_d(gridIn.getXRes(), gridIn.getYRes());
        Buffer_d swap;

        for (int step = 0; step < steps; step++) {
            processHelper(gridIn, gridOut);

            swap = gridOut;
            gridOut = gridIn;
            gridIn = swap;
        }

        return gridOut;
    }

    private void processHelper(Buffer_d gridIn, Buffer_d gridOut) {

        for (int x = 0; x < gridIn.getXRes(); x++) {
            for (int y = 0; y < gridIn.getYRes(); y++) {
                LDouble value = gridIn.pointAverage(x, y, 4);
                value.val = transform(value.val);
                gridOut.setValue(x, y, value);
            }
        }
    }

    private double transform(double val) {
        // use squashing function: 0-1
        val = 2 * val - 1; // scale from -1 to 1
        val = Math.signum(val) * Math.pow(Math.abs(val), 1.0 / sharpness);

        val = Math.sin((Math.PI / 2) * val);
        val = (1 + val) / 2; // scale back
        return val;
    }
}
