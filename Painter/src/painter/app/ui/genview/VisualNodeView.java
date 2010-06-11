/*
 * VisualNodeView.java
 *
 * Created on April 13, 2006, 11:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.component.expression.Expression;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Calvin Ashmore
 */
public class VisualNodeView extends JLayeredPane { //JPanel {

    private List<VisualNode> frames;
    private Map<Expression, VisualNode> nodeMap;
    private static final Color bgColor = new Color(220, 220, 220);
    private static final Color borderColor = new Color(100, 100, 100);
    private Expression root;
    private int heightPadding = 30;
    private int widthPadding = 30;

    public VisualNodeView(Expression expression) {

        setBackground(bgColor);
        setOpaque(true);

        buildExpressionTree(expression);
        setBorder(new LineBorder(borderColor, 1));
    }

    private void buildExpressionTree(Expression newRoot) {
        root = newRoot;

        if (frames != null) {
            for (VisualNode frame : frames) {
                remove(frame);
            }
        }

        frames = new ArrayList();
        nodeMap = new Hashtable();
        int i = 0;
        for (Expression Expression : gatherNodes(root)) {

            VisualNode vn = new VisualNode(Expression);
            vn.setLocation(50 + i * 20, 50 + i * 20);
            frames.add(vn);
            add(vn);
            nodeMap.put(Expression, vn);
            vn.setVisible(true);

            i++;
        }

        buildBounds(root, 0, 0);
        repaint();
    }

    private List<Expression> gatherNodes(Expression base) {
        return gatherNodesHelper(base, new ArrayList<Expression>());
    }

    private List<Expression> gatherNodesHelper(Expression base, List<Expression> gatheredSoFar) {
        gatheredSoFar.add(base);
        for (int i = 0; i < base.getNumberInputs(); i++) {
            gatherNodesHelper(base.getInput(i), gatheredSoFar);
        }

        return gatheredSoFar;
    }

    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);

        if (root == null) {
            return;
        }

        for (VisualNode vn : frames) {

            Expression Expression = vn.getBase();
            for (int i = 0; i < Expression.getNumberInputs(); i++) {
                if (Expression.getInput(i) != null) {
                    drawConnection(g, vn.getInputPoint(i), nodeMap.get(Expression.getInput(i)).getOutputPoint());
                }
            }
        }
        paintBorder(g);
    }

    public void drawConnection(java.awt.Graphics g, Point point1, Point point2) {
        g.setColor(new Color(0, 0, 0));

        int screenX = getLocationOnScreen().x;
        int screenY = getLocationOnScreen().y;

        float dx = point1.x - point2.x;
        float dy = point1.y - point2.y;
        float mag = (float) Math.sqrt(dx * dx + dy * dy);
        if (mag != 0) {
            dx /= mag;
            dy /= mag;
        }

        int ix = (int) (1.2f * dx * CirclePanel.circleWidth / 2);
        int iy = (int) (1.2f * dy * CirclePanel.circleWidth / 2);

        Point point1a = new Point(
                point1.x - ix,
                point1.y - iy);

        Point point2a = new Point(
                point2.x + ix,
                point2.y + iy);

        g.drawLine(
                point1a.x - screenX, point1a.y - screenY,
                point2a.x - screenX, point2a.y - screenY);
    }

    private void buildBounds(Expression boundsRoot, int x0, int y0) {
        List<Expression> currentNodes = new ArrayList();
        List<Expression> visibleNodes = gatherNodes(root);

        currentNodes.add(boundsRoot);

        int depth = 0;
        while (!currentNodes.isEmpty()) {
            List<Expression> nextNodes = new ArrayList();

            for (Expression Expression : currentNodes) {
                nodeMap.get(Expression).depth = depth;
                for (int i = 0; i < Expression.getNumberInputs(); i++) {
                    nextNodes.add(Expression.getInput(i));
                }
            }

            depth++;
            currentNodes = nextNodes;
        }
        int maxDepth = depth;
        int maxHeight = 0;

        int heights[] = new int[maxDepth];
        int widths[] = new int[maxDepth];
        int netWidths[] = new int[maxDepth];

        for (Expression n : visibleNodes) {
            VisualNode vn = nodeMap.get(n);
            heights[vn.depth] += vn.getSize().height + heightPadding;
            widths[vn.depth] = Math.max(widths[vn.depth], vn.getSize().width);
        }

        for (int height : heights) {
            if (maxHeight < height) {
                maxHeight = height;
            }
        }

        for (int i = 0; i < maxDepth; i++) {
            for (int j = 0; j < i; j++) {
                netWidths[i] += widths[j];
            }
        }
        int maxWidth = netWidths[maxDepth-1] + widths[maxDepth-1];

        int currentHeights[] = new int[maxDepth];

        for (Expression n : visibleNodes) {
            VisualNode vn = nodeMap.get(n);
            vn.setLocation(
                    netWidths[vn.depth] + vn.depth * widthPadding + x0,
                    (maxHeight - heights[vn.depth]) / 2 + currentHeights[vn.depth] + y0);
            currentHeights[vn.depth] += vn.getSize().height + heightPadding;
        }

        setPreferredSize(new Dimension(maxWidth+100, maxHeight));
    }
}
