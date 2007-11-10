/*
 * BuildException.java
 * 
 * Created on Nov 4, 2007, 5:50:52 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.util;

/**
 *
 * @author Calvin Ashmore
 */
public class BuildException  extends Exception {
    public BuildException() {super();}
    public BuildException(String message) {super(message);}
    public BuildException(Throwable cause) {super(cause);}
    public BuildException(String message, Throwable cause) {super(message, cause);}
}
