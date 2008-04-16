/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import painter.foundation.typehandlers.BooleanHandler;
import painter.foundation.typehandlers.ColorHandler;
import painter.foundation.typehandlers.ComplexHandler;
import painter.foundation.typehandlers.IntegerHandler;
import painter.foundation.typehandlers.LDoubleHandler;
import painter.foundation.typehandlers.LVect2dHandler;
import painter.foundation.typehandlers.LVect3dHandler;
import utils.linear.Color;
import utils.linear.Complex;
import utils.linear.LDouble;
import utils.linear.LVect2d;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class TypeSystem implements genetic.TypeSystem {

    private Map<Class, TypeHandler> handlers;
    private List<Class> allTypes;

    public TypeSystem() {
        handlers = new HashMap<Class, TypeHandler>();
        handlers.put(Integer.class, new IntegerHandler());
        handlers.put(LDouble.class, new LDoubleHandler());
        handlers.put(LVect2d.class, new LVect2dHandler());
        handlers.put(LVect3d.class, new LVect3dHandler());
        handlers.put(Color.class, new ColorHandler());
        handlers.put(Boolean.class, new BooleanHandler());
        handlers.put(Complex.class, new ComplexHandler());

        allTypes = new ArrayList<Class>(handlers.keySet());
    }

    public List<Class> allTypes() {
        return allTypes;
    }

    public Object perturbValue(Object obj) {
        if(handlers.get(obj.getClass()) != null)
            return handlers.get(obj.getClass()).perturbValue(obj);
        return obj;
    }

    public Object checkInvalid(Object obj) {
        if(handlers.get(obj.getClass()) != null)
            return handlers.get(obj.getClass()).checkInvalid(obj);
        return obj;
    }

    public Object createDefault(Class c) {
        if(handlers.get(c) != null)
            return handlers.get(c).createDefault();
        return null;
    }

    public Object createRandom(Class c) {
        if(handlers.get(c) != null)
            return handlers.get(c).createRandom();
        return null;
    }
}
