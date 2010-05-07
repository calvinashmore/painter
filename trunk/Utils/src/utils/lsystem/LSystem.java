/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.lsystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
public class LSystem {

    private Map<Character, String> rules = new HashMap<Character, String>();

    public void addRule(char c, String replacement) {
        rules.put(c, replacement);
    }

    public String apply(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String replacement = rules.get(c);

            if (replacement != null) {
                sb.append(replacement);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String apply(String input, int generations) {
        for (int i = 0; i < generations; i++) {
            input = apply(input);
        }
        return input;
    }
}
