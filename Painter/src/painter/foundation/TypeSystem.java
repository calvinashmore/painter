/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import painter.foundation.typehandlers.ColorHandler;
import painter.foundation.typehandlers.IntegerHandler;
import painter.foundation.typehandlers.LDoubleHandler;
import painter.foundation.typehandlers.LVect2dHandler;
import utils.linear.Color;
import utils.linear.LDouble;
import utils.linear.LVect2d;

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
        handlers.put(Color.class, new ColorHandler());

        allTypes = new ArrayList<Class>(handlers.keySet());
    }

    public List<Class> allTypes() {
        return allTypes;
    }

    public Object perturbValue(Object obj) {
        return handlers.get(obj.getClass()).perturbValue(obj);
    }

    public Object checkInvalid(Object obj) {
        return handlers.get(obj.getClass()).checkInvalid(obj);
    }

    public Object createDefault(Class c) {
        return handlers.get(c).createDefault();
    }

    public Object createRandom(Class c) {
        return handlers.get(c).createRandom();
    }
}
