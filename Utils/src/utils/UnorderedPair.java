/*
 * UpdatePair.java
 *
 * Created on June 12, 2005, 6:15 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package utils;

/**
 * This is a pair of items of the same type with a special property,
 * @author Calvin Ashmore
 */
public class UnorderedPair<T> {

    private T a;
    private T b;

    /** Creates a new instance of UpdatePair */
    public UnorderedPair(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public T getLeft() {
        return a;
    }

    public T getRight() {
        return b;
    }

    @Override
    public String toString() {
        return "[" + a.toString() + ", " + b.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnorderedPair<T> other = (UnorderedPair<T>) obj;

        // if (this.a == other.a && this.b == other.b) -> true
        // if (this.a == other.b && this.b == other.a) -> true

        if ((this.a == other.a || (this.a != null && this.a.equals(other.a)))
                && (this.b == other.b || (this.b != null && this.b.equals(other.b)))) {
            return true;
        }

        if ((this.a == other.b || (this.a != null && this.a.equals(other.b)))
                && (this.b == other.a || (this.b != null && this.b.equals(other.a)))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.a != null ? this.a.hashCode() : 0) + (this.b != null ? this.b.hashCode() : 0);
        return hash;
    }
}
