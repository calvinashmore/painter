/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import genetic.component.method.Method;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
public interface GeneticTopLevel extends GeneticComponent {
    
    public Method createMethod(String name, Class... parameters);
    public void callMethod(String name, Object... parameters);
    public Map<String, Method> getMethods();
    
    /*public void createCommand(String name, Command command);
    public void createAccessor(String name, Accessor accessor);
    
    public List<String> getCommands();
    public List<String> getAccessors();
    
    public List<String> getAccessorsByType(Class type);
    
    public Command getCommand(String name);
    public Accessor getAccessor(String name);*/
    
}
