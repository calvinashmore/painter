/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation;

/**
 *
 * @author Calvin Ashmore
 */
public interface TypeHandler<T> {

    public T perturbValue(T obj);

    public T checkInvalid(T obj);

    public T createDefault();

    public T createRandom();
}
