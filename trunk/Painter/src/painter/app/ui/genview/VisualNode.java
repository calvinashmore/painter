/*
 * VisualNode.java
 *
 * Created on April 13, 2006, 11:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package painter.app.ui.genview;


import genetic.component.expression.Expression;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VisualNode extends JPanel {
    
    protected static Color nameTextColor = new Color(80,80,80);
    protected static Color titleBarBGColor = new Color(120,120,140);
    protected static Color titleBarRootBGColor = new Color(100,100,140);
    protected static Color titleBarTextColor = new Color(230,230,250);
    protected static Color mainBlockColor = new Color(235,235,235);
    
    protected static Font titleFont = new Font("Arial",Font.PLAIN,12);
    protected static Font nameFont = new Font("Arial",Font.PLAIN,10);
    
    protected static Font  parameterNameFont  = new Font("Arial",Font.BOLD,11);
    protected static Color parameterNameColor = new Color(0,0,0);
    protected static Font  parameterTypeFont  = new Font("Arial",Font.PLAIN,11);
    protected static Color parameterTypeColor = new Color(0,0,30);
    protected static Font  parameterValueFont  = new Font("Arial",Font.PLAIN,11);
    protected static Color parameterValueColor = new Color(0,0,0);
    
    // include edit parameter things somehow?
    
    protected static final int titleBarHeight = 25;
    
    private Expression base;
//    private java.util.List<VisualParameter> parameters;
    
    public int depth;
    
    private CirclePanel outputCircle;
    private CirclePanel inputCircles[];
    
    private JPanel titleBarRef;

//    private JPopupMenu popup;
//    private MouseListener mouseAdapter;
    
    public void setIsRoot(boolean isRoot) {
        if(isRoot)
            titleBarRef.setBackground(titleBarRootBGColor);
        else
            titleBarRef.setBackground(titleBarBGColor);
    }
    
    public Point getOutputPoint() {
        return new Point(
                outputCircle.getLocationOnScreen().x+CirclePanel.circleWidth/2,
                outputCircle.getLocationOnScreen().y+CirclePanel.circleWidth/2);
    }
    
    public Point getInputPoint(int i) {
        return new Point(
                inputCircles[i].getLocationOnScreen().x+CirclePanel.circleWidth/2,
                inputCircles[i].getLocationOnScreen().y+CirclePanel.circleWidth/2);
    }
    
    
    public Expression getBase() {return base;}
    
    public VisualNode(Expression base) {
        
        this.base = base;
        
//        parameters = new java.util.ArrayList();
//        popup = new VisualNodePopupMenu(this);
//        mouseAdapter = new PopupAdapter();
//
        setLayout(new BorderLayout());
        
        JPanel panel1, panel2, panel3;
        panel1 = createLeftPanel();
        panel2 = createMainPanel();
        panel3 = createRightPanel();
        
//        panel2.addMouseListener(mouseAdapter);
        
        //add(titlePanel, BorderLayout.NORTH);
        add( panel1, BorderLayout.WEST );
        add( panel2, BorderLayout.CENTER );
        if(panel3 != null)
            add( panel3, BorderLayout.EAST );
        
        if(panel3 != null)
            setSize(
                    panel1.getPreferredSize().width + panel2.getPreferredSize().width +panel3.getPreferredSize().width,
                    Math.max(panel1.getPreferredSize().height, Math.max(panel2.getPreferredSize().height, panel3.getPreferredSize().height) ) );
        else 
            setSize(
                    panel1.getPreferredSize().width + panel2.getPreferredSize().width,
                    Math.max(panel1.getPreferredSize().height, panel2.getPreferredSize().height) );
        setOpaque(false);
        //setBackground(new Color(0,0,0,255));
    }
    
    public void toFront() {
        if (getParent() instanceof JLayeredPane)
            ((JLayeredPane) getParent()).moveToFront(this);
    }
    
    protected class CircleTextPanel extends JPanel {
        CircleTextPanel(CirclePanel circle, String text) {
            
            JLabel outputLabel = new JLabel(text);
            outputLabel.setForeground(nameTextColor);
            outputLabel.setFont(nameFont);

            JPanel circleContainer = new JPanel();
            circleContainer.setLayout(new BoxLayout(circleContainer, BoxLayout.X_AXIS));
            circleContainer.add( Box.createHorizontalGlue() );
            circleContainer.add( circle );
            circleContainer.add( Box.createHorizontalGlue() );
            circleContainer.setOpaque(false);
            //circleContainer.setBackground(new Color(180,180,200));

            //JPanel textContainer = new JPanel();
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add( outputLabel );
            add( circleContainer );
            setOpaque(false);
        }
    }
    
    protected JPanel createMainPanel() {
        
        final JPanel titleBar = createTitleBar();
        titleBarRef = titleBar;
        
        JPanel panel = new JPanel();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder( new EmptyBorder(8,8,8,8) );
        panel.add( titleBar );
        
        panel.setBackground(mainBlockColor);
        
//        DragMouseAdapter adapter =
//                new DragMouseAdapter(this);
//        panel.addMouseListener(adapter);
//        panel.addMouseMotionListener(adapter);
        
        int numberRows = base.getNumberParameters();
        if(numberRows > 0) {
        
            JPanel parameterTable = new ParameterPanel(base);//new JPanel();
            //parameterTable.setLayout( new GridLayout(numberRows,3) );
//            parameterTable.setLayout( new GridBagLayout() );
//            parameterTable.setBackground(mainBlockColor);
//            parameterTable.setMaximumSize( new Dimension (
//                    Short.MAX_VALUE, Short.MAX_VALUE
//                    ) );
            panel.add(parameterTable);
//
//            for(int i=0;i<numberRows;i++) {
//
//                VisualParameter param = new VisualParameter(
//                        base.getParameterType(i),
//                        base.getParameterValue(i)
//                        );
//                parameters.add(param);
//
//                JLabel parameterName = new JLabel(base.getParameterName(i));
//                parameterName.setFont(parameterNameFont);
//                parameterName.setForeground(parameterNameColor);
//
//                JLabel parameterType = new JLabel(param.getTypeName());
//                parameterType.setFont(parameterTypeFont);
//                parameterType.setForeground(parameterTypeColor);
//
//                GridBagConstraints constraints = new GridBagConstraints();
//                constraints.gridy = i;
//                constraints.ipadx = 12;
//                constraints.ipady = 4;
//                constraints.anchor = constraints.NORTHWEST;
//
//                constraints.gridx = 0;
//                parameterTable.add(parameterType, constraints);
//
//                constraints.gridx = 1;
//                parameterTable.add(parameterName, constraints);
//
//                constraints.gridx = 2;
//                constraints.weightx = 1;
//
//                Component valueComponent = param.getComponent();
//                parameterTable.add(valueComponent, constraints);
//
//                valueComponent.setFont(parameterValueFont);
//                valueComponent.setForeground(parameterValueColor);
//
//            }
        }
        
        return panel;
    }
    
    protected JPanel createLeftPanel() {
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        //panel.setBackground(new Color(200,180,180));
        
        String outputName = base.getOutputType().getName();
        outputName = outputName.substring(outputName.lastIndexOf(".")+1);
        
        CirclePanel circlePanel = new CirclePanel(this,true,0);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add( Box.createVerticalGlue() );
        panel.add( new CircleTextPanel(circlePanel, outputName) );
        panel.add( Box.createVerticalGlue() );
        panel.setBorder( new EmptyBorder(3,3,3,3) );
        
        outputCircle = circlePanel;
                
        return panel;
    }
    
    protected JPanel createRightPanel() {
        
        if(base.getNumberInputs() == 0)
            return null;
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add( Box.createVerticalGlue() );
        panel.setBorder( new EmptyBorder(3,3,3,3) );
        
        inputCircles = new CirclePanel[base.getNumberInputs()];
        
        for(int i=0;i<base.getNumberInputs();i++) {
            
            CirclePanel circlePanel = new CirclePanel(this,false,i);
            
            String inputName = base.getInputType(i).getName();
            inputName = inputName.substring(inputName.lastIndexOf(".")+1);
            inputName = base.getInputName(i) + ": " + inputName;
            
            panel.add( new CircleTextPanel(circlePanel, inputName) );
            panel.add( Box.createVerticalGlue() );
            
            inputCircles[i] = circlePanel;
        }
        
        panel.setPreferredSize( new Dimension(
                panel.getPreferredSize().width,
                (int)(panel.getPreferredSize().height * 1.5) ) );
        
        panel.setOpaque(false);
        return panel;
    }
    
    
    // create the title bar m_titlePanel
    protected JPanel createTitleBar() {
        
        String titleName = base.getName();
        titleName = titleName.substring(titleName.lastIndexOf(".")+1);
        
        final JLabel titleLabel = new JLabel(titleName);
        titleLabel.setForeground(titleBarTextColor);
        titleLabel.setFont(titleFont);
        
        JPanel titlePanel = new JPanel();
        
        Dimension dim = new Dimension(
                titleLabel.getPreferredSize().width + 25,
                titleLabel.getPreferredSize().height + 5
                );
        titlePanel.setPreferredSize(dim);
        titlePanel.setMaximumSize( new Dimension (
                Short.MAX_VALUE, dim.height
                ) );
        titlePanel.setMinimumSize(dim);
        
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setOpaque(true);
        titlePanel.setBackground(titleBarBGColor);
        titlePanel.setBorder( new EmptyBorder(3,3,3,3) );
        
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        
        return titlePanel;
    }

//    public void refresh() {
//        for(int i=0;i<base.getNumberParameters();i++) {
//            parameters.get(i).setValue(base.getParameterValue(i));
//        }
//    }
    
        
}