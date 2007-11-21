/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import genetic.component.expression.accessor.Accessor;
import genetic.component.statement.command.Command;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public interface GeneticTopLevel extends GeneticComponent {
    
    public void createEvent(String name, Class... parameters);
    public void callEvent(String name, Object... parameters);
    
    public void createCommand(String name, Command command);
    public void createAccessor(String name, Accessor accessor);
    
    public List<String> getCommands();
    public List<String> getAccessors();
    
    public List<String> getAccessorsByType(Class type);
    
    public Command getCommand(String name);
    public Accessor getAccessor(String name);
    
}
