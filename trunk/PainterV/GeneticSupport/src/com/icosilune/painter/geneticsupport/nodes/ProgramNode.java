/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.nodes;

import genetic.GeneticTopLevel;
import genetic.component.method.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openide.nodes.Node;
import org.openide.nodes.PropertySupport.ReadOnly;
import org.openide.nodes.Sheet;
import org.openide.nodes.Sheet.Set;

/**
 *
 * @author Calvin Ashmore
 */
public class ProgramNode extends GeneticNode<GeneticTopLevel> {

    private static final String IMAGE_ICON_BASE = "com/icosilune/painter/geneticsupport/nodes/icons/program.png";
    
    public ProgramNode(GeneticTopLevel object) {
        super(object);
        setIconBaseWithExtension(IMAGE_ICON_BASE);
        setName("Program");
    }

    @Override
    public String getHtmlDisplayName() {
        return "<b><i>Program</i></b>";
    }
    
    @Override
    protected Node createNode(Object obj) {
        Map.Entry<String, Method> methodSignature = (Map.Entry<String, Method>)obj;
        return new MethodNode(methodSignature.getKey(), methodSignature.getValue());
    }

    @Override
    protected List getGeneticChildren() {
        List<Map.Entry<String, Method>> children =
                new ArrayList<Map.Entry<String, Method>>(getComponent().getMethods().entrySet());
        return children;
    }

    /*@Override
    protected Sheet createSheet() {
        Sheet sheet = new Sheet();
        Set properties = Sheet.createPropertiesSet();
        properties.put(new ReadOnly<Integer>("thingy", Integer.class, "A Thingy", "The Thingy Property") {
            
            @Override
            public Integer getValue() throws IllegalAccessException, InvocationTargetException {
                return 12345;
            }
        });
        
        sheet.put(properties);
        return sheet;
    }*/
}
