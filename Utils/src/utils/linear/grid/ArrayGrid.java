/*
 * Grid.java
 *
 * Created on February 20, 2005, 1:56 PM
 */
package utils.linear.grid;

import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
public class ArrayGrid<T extends Linear<T>>
        implements Grid<T>, Linear<Grid<T>> {

    T values[][];
    int xres, yres;

    public ArrayGrid(ArrayGrid<T> g) {
        xres = g.xres;
        yres = g.yres;

        values = forceArray(xres, yres, g.values[0][0]);

        try {
            Class tclass = g.values[0][0].getClass();
            java.lang.reflect.Constructor tconstruct = tclass.getConstructor(tclass);
            // we will be hit by an exception in the case that this doesn't exist
            // but every implementation of Linear should have a copy constructor

            for (int i = 0; i < xres; i++) {
                for (int j = 0; j < xres; j++) {
                    values[i][j] = (T) tconstruct.newInstance(g.values[i][j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            values = null;
            xres = 0;
            yres = 0;
        }
    }

    public ArrayGrid(int sizex, int sizey, T base) {
        xres = sizex;
        yres = sizey;

        values = forceArray(xres, yres, base);
    }

    public ArrayGrid() {
        values = null;
        xres = 0;
        yres = 0;
    }

    public T getValue(int x, int y) {
        return values[x][y];
    }

    public void setValue(int x, int y, T val) {
        values[x][y] = val;
    }

    public int getXRes() {
        return xres;
    }

    public int getYRes() {
        return yres;
    }

    private T[][] forceArray(int xs, int ys, T base) {
        Class tclass = base.getClass();
        int dims[] = new int[2];
        dims[0] = xs;
        dims[1] = ys;

        T[][] R = (T[][]) (java.lang.reflect.Array.newInstance(tclass, dims));
        try {
            java.lang.reflect.Constructor tconstruct = tclass.getConstructor(tclass);
            // we will be hit by an exception in the case that this doesn't exist
            // but every implementation of Linear should have a copy constructor

            for (int i = 0; i < xres; i++) {
                for (int j = 0; j < yres; j++) {
                    R[i][j] = (T) tconstruct.newInstance(base);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return R;
    }

    public ArrayGrid<T> zero() {
        return new ArrayGrid<T>();
    }

    void assertSize(Grid g) {
        assertSize(g, null);
    }

    void assertSize(Grid g, String message) {
        if (xres != g.getXRes() || yres != g.getYRes()) {
            throw new GridSizeException(message);
        }
    }

    public ArrayGrid<T> add(Grid<T> a) {
        assertSize(a);
        ArrayGrid<T> r = new ArrayGrid<T>(this);

        for (int i = 0; i < xres; i++) {
            for (int j = 0; j < yres; j++) {
                r.values[i][j] = values[i][j].add(a.getValue(i, j));
            }
        }
        return r;
    }

    public void addv(Grid<T> a) {
        assertSize(a);
        for (int i = 0; i < xres; i++) {
            for (int j = 0; j < yres; j++) {
                values[i][j].addv(a.getValue(i, j));
            }
        }
    }

    public ArrayGrid<T> sub(Grid<T> a) {
        assertSize(a);
        ArrayGrid<T> r = new ArrayGrid<T>(this);

        for (int i = 0; i < xres; i++) {
            for (int j = 0; j < yres; j++) {
                r.values[i][j] = values[i][j].sub(a.getValue(i, j));
            }
        }
        return r;
    }

    public void subv(Grid<T> a) {
        assertSize(a);

        for (int i = 0; i < xres; i++) {
            for (int j = 0; j < yres; j++) {
                values[i][j].subv(a.getValue(i, j));
            }
        }
    }

    public ArrayGrid<T> mult(double c) {
        ArrayGrid<T> r = new ArrayGrid<T>(this);

        for (int i = 0; i < xres; i++) {
            for (int j = 0; j < yres; j++) {
                r.values[i][j] = values[i][j].mult(c);
            }
        }
        return r;
    }

    public void multv(double c) {
        for (int i = 0; i < xres; i++) {
            for (int j = 0; j < yres; j++) {
                values[i][j].multv(c);
            }
        }
    }

    public ArrayGrid<T> normal() {
        double m = 1.0 / magnitude();
        return mult(m);
    }

    public void normalv() {
        double m = 1.0 / magnitude();
        multv(m);
    }

    public double magnitude() {
        double r = 0;
        for (int i = 0; i < xres; i++) {
            for (int j = 0; j < yres; j++) {
                double v = values[i][j].magnitude();
                r += v * v;
            }
        }
        r = Math.sqrt(r);
        return r / (xres * yres);
    }

    public T pointAverage(int x, int y) {
        return pointAverage(x, y, 1, 1);
    }

    public T pointAverage(int x, int y, int r) {
        return pointAverage(x, y, r, r);
    }

    public T pointAverage(int x, int y, int rx, int ry) {
        int count = 0;
        T avg = values[0][0].zero();
        for (int xt = x - rx; xt <= x + rx; xt++) {
            for (int yt = y - ry; yt <= y + ry; yt++) {
                if (xt < 0 || xt >= xres || yt < 0 || yt >= yres) {
                    continue;
                }
                avg.addv(values[xt][yt]);
                count++;
            }
        }
        avg.multv(1.0 / count);
        return avg;
    }

    public void average() {
        average(1, 1);
    }

    public void average(int radius) {
        average(radius, radius);
    }

    public void average(int rx, int ry) {
        ArrayGrid<T> g = new ArrayGrid<T>(this);
        for (int i = 0; i < xres; i++) {
            for (int j = 0; j < yres; j++) {
                g.values[i][j] = pointAverage(i, j, rx, ry);
            }
        }
        values = g.values;
    }

    public T pointGaussAverage(double x, double y, int radius, double sharpness) {
        double net = 0;
        T avg = values[0][0].zero();

        int ix = (int) x;
        int iy = (int) y;

        for (int xt = ix - radius; xt <= ix + radius; xt++) {
            for (int yt = iy - radius; yt <= iy + radius; yt++) {
                if (xt < 0 || xt >= xres || yt < 0 || yt >= yres) {
                    continue;
                }
                double dist2 = (xt - x) * (xt - x) + (yt - y) * (yt - y);
                double weight = Math.exp(-dist2 * sharpness);

                avg.addv(values[xt][yt].mult(weight));
                net += weight;
            }
        }
        avg.multv(1.0 / net);
        return avg;
    }

    public void gaussAverage(int radius, double sharpness) {
        ArrayGrid<T> g = new ArrayGrid<T>(this);
        for (int i = 0; i < xres; i++) {
            for (int j = 0; j < yres; j++) {
                g.values[i][j] = pointGaussAverage(i, j, radius, sharpness);
            }
        }
        values = g.values;
    }

    private double splineEval(double t, int lev) {
        switch (lev) {
            case -1:
                return (1 / 6.0) * (1 - 3 * t + 3 * t * t - t * t * t);
            case 0:
                return (1 / 6.0) * (4 - 6 * t * t + 3 * t * t * t);
            case 1:
                return (1 / 6.0) * (1 + 3 * t + 3 * t * t - 3 * t * t * t);
            case 2:
                return (1 / 6.0) * (t * t * t);
        }
        return 0;
    }

    private int wrap(int ix, GridWrapMethod wrapMethod, int max) {
        //if(wrapMethod == GridWrapMethod.zero)
        //    return -1;
        if (wrapMethod == GridWrapMethod.extend) {
            if (ix < 0) {
                return 0;
            } else if (ix >= max) {
                return max - 1;
            } else {
                return ix;
            }
        } else if (wrapMethod == GridWrapMethod.mirror) {
            ix = (ix / max) % 2 == 0 ? ix % max : (max - 1 - ix) % max;
            if (ix < 0) {
                ix = (max + ix) % max;
            }
            return ix;
        } else if (wrapMethod == GridWrapMethod.repeat) {
            ix %= max;
            if (ix < 0) {
                ix = (max + ix) % max;
            }
            return ix;
        } else {
            return -1;
        }
    }

    public T getValueWrap(int ix, int iy, GridWrapMethod xWrapMethod, GridWrapMethod yWrapMethod) {

        //try{

        ix = wrap(ix, xWrapMethod, xres);
        iy = wrap(iy, yWrapMethod, yres);
        if (ix < 0 || iy < 0) {
            return getValue(0, 0).zero();
        } else {
            return getValue(ix, iy);
        /*} catch(Exception e) {
        int foo = 1;
        return getValue(0,0).zero();
        }*/
        }
    }

    public T evalScale(double x, double y, GridWrapMethod xWrapMethod, GridWrapMethod yWrapMethod, GridScaleMethod scaleMethod) {

        switch (scaleMethod) {
            case square: {
                int ix = (int) x;
                int iy = (int) y;

                return getValueWrap(ix, iy, xWrapMethod, yWrapMethod);
            }
            case linear: {

                int ix = (int) x;
                int iy = (int) y;

                if (x < 0) {
                    ix--;
                }
                if (y < 0) {
                    iy--;
                }
                double dx = x - ix;
                double dy = y - iy;

                T influence1 = getValueWrap(ix, iy, xWrapMethod, yWrapMethod).mult((1 - dx) * (1 - dy));
                T influence2 = getValueWrap(ix + 1, iy, xWrapMethod, yWrapMethod).mult((dx) * (1 - dy));
                T influence3 = getValueWrap(ix, iy + 1, xWrapMethod, yWrapMethod).mult((1 - dx) * (dy));
                T influence4 = getValueWrap(ix + 1, iy + 1, xWrapMethod, yWrapMethod).mult((dx) * (dy));
                return influence1.add(influence2).add(influence3).add(influence4);
            }
            case cubic: {

                int ix = (int) x;
                int iy = (int) y;

                if (x < 0) {
                    ix--;
                }
                if (y < 0) {
                    iy--;
                }
                double dx = x - ix;
                double dy = y - iy;

                T net = getValue(0, 0).zero();

                for (int xx = -1; xx <= 2; xx++) {
                    for (int yy = -1; yy <= 2; yy++) {
                        T value = getValueWrap(ix + xx, iy + yy, xWrapMethod, yWrapMethod);
                        net.addv(value.mult(splineEval(dx, xx) * splineEval(dy, yy)));
                    }
                }
                return net;
            }
        }

        // unreachable
        return getValue(0, 0).zero();
    }

    public ArrayGrid<T> rescale(int nxres, int nyres) {
        return rescale(nxres, nyres, GridScaleMethod.linear);
    }

    public ArrayGrid<T> rescale(int nxres, int nyres, GridScaleMethod method) {
        ArrayGrid<T> r = new ArrayGrid<T>(nxres, nyres, this.getValue(0, 0));
        switch (method) {
            case square:
                 {
                    for (int i = 0; i < nxres; i++) {
                        for (int j = 0; j < nxres; j++) {
                            int ii = (int) (((double) i / (nxres - 1)) * (xres - 1));
                            int jj = (int) (((double) j / (nyres - 1)) * (yres - 1));
                            r.setValue(i, j, getValue(ii, jj));
                        }
                    }
                }
                break;

            case linear:
                 {
                    for (int i = 0; i < nxres; i++) {
                        for (int j = 0; j < nxres; j++) {
                            double dii = ((double) i / nxres) * (xres - 1);
                            double djj = ((double) j / nyres) * (yres - 1);

                            int ii = (int) dii;
                            int jj = (int) djj;

                            dii -= ii;
                            djj -= jj;

                            T influence1 = getValue(ii, jj).mult((1 - dii) * (1 - djj));
                            T influence2 = getValue(ii + 1, jj).mult((dii) * (1 - djj));
                            T influence3 = getValue(ii, jj + 1).mult((1 - dii) * (djj));
                            T influence4 = getValue(ii + 1, jj + 1).mult((dii) * (djj));
                            T net = influence1.add(influence2).add(influence3).add(influence4);

                            r.setValue(i, j, net);
                        }
                    }
                }
                break;

            case cubic: {
                for (int i = 0; i < nxres; i++) {
                    for (int j = 0; j < nxres; j++) {
                        double dii = ((double) i / nxres) * (xres - 1);
                        double djj = ((double) j / nyres) * (yres - 1);

                        int ii = (int) dii;
                        int jj = (int) djj;

                        dii -= ii;
                        djj -= jj;

                        // force a zero element
                        T net = getValue(0, 0).zero();

                        for (int x = -1; x <= 2; x++) {
                            for (int y = -1; y <= 2; y++) {
                                T value = getValue(Math.max(Math.min(ii + x, xres - 1), 0), Math.max(Math.min(jj + y, yres - 1), 0));
                                net.addv(value.mult(splineEval(dii, x) * splineEval(djj, y)));
                            }
                        }
                        r.setValue(i, j, net);
                    }
                }
            }
        }

        return r;
    }

    @Override
    public Grid<T> clone() {
        return new ArrayGrid(this);
    }

    public void setTo(Grid<T> a) {
        assertSize(a);
        for (int x = 0; x < xres; x++) {
            for (int y = 0; y < yres; y++) {
                setValue(x, y, a.getValue(x, y));
            }
        }
    }
}
