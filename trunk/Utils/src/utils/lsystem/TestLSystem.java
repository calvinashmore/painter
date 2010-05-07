/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.lsystem;

/**
 *
 * @author Calvin Ashmore
 */
public class TestLSystem {

    public static void main(String args[]) {
        LSystem ls = new LSystem();
        ls.addRule('F', "F+F-");
        ls.addRule('+', "+fG-");

        String s = "F";
        System.out.println("0: " + s);
        for (int i = 1; i < 6; i++) {
            s = ls.apply(s);
            System.out.println(i + ": " + s);
        }
    }
}
