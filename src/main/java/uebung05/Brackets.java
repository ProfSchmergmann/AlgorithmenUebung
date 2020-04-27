package uebung05;

import java.util.ArrayDeque;

/**
 * Class Brackets.
 *
 * @author Sven Bergmann
 * @version 27.04.2020
 */
public class Brackets {

    /**
     * Method to check if the brackets in a String are valid.
     *
     * @param s the String to check
     * @return false, if there are not enough brackets,
     * true, if the brackets are valid.
     */
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        char currentChar;
        // Fill queue with the opening brackets.
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
                if (arrayDeque.isEmpty()) {
                    return false;
                }
                break;
            }
            if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
                arrayDeque.addFirst(currentChar);
            }
        }
        // Check if there are brackets in this queue.
        if (arrayDeque.isEmpty()) {
            return true;
        }
        // If the size of this String is bigger or equal to the size of the brackets in the deque,
        // there cannot be enough closing brackets.
        if (s.length() == arrayDeque.size() || 2 * arrayDeque.size() > s.length()) {
            return false;
        }
        char bracket = arrayDeque.pollFirst();
        // Check if the closing brackets fit to the opening brackets.
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
                if (bracket == Brackets.getOppositeBracket(currentChar)) {
                    if (arrayDeque.isEmpty()) {
                        bracket = ' ';
                    } else {
                        bracket = arrayDeque.pollFirst();
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Private method for returning the opposing bracket.
     *
     * @param bracket the bracket
     * @return the opposing bracket
     */
    private static char getOppositeBracket(char bracket) {
        switch (bracket) {
            case '(':
                return ')';
            case ')':
                return '(';
            case '[':
                return ']';
            case ']':
                return '[';
            case '{':
                return '}';
            case '}':
                return '{';
            default:
                throw new IllegalArgumentException("No correct bracket found!");
        }
    }

}
