package uebung08;

import java.util.ArrayDeque;

/**
 * Class for printing permutations.
 *
 * @author Sven Bergmann
 * @version 19.05.2020
 */
public class Permutationen {

    /**
     * Method for printing all permutations from 1 to the given number.
     *
     * @param n upper bound
     */
    public static void printPermutationen(int n) {
        if (n < 1) {
            throw new ArithmeticException("Number out of bounds.");
        } else {
            String s = "";
            for (int i = 1; i <= n; i++) {
                s += i;
            }
            printPermutationen("", s);
        }
    }

    /**
     * Method for recursively building the permutations.
     *
     * @param prefix the String to be printed
     * @param string the String from which we want to print the permutations
     */
    private static void printPermutationen(String prefix, String string) {
        int n = string.length();
        if (n == 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            System.out.println(prefix);
        }
        for (int i = 0; i < n; i++) {
            printPermutationen(prefix + string.charAt(i) + ",", string.substring(0, i) + string.substring(i + 1, n));
        }
    }

    /**
     * Method for printing all permutations of n ones and ges - n zeros.
     *
     * @param n   the amount of ones
     * @param ges the total number
     */
    public static void printPermutationen2(int n, int ges) {
        if (n > ges) {
            throw new ArithmeticException("Number of ones cannot be bigger than total length of the String.");
        } else {
            printPermutationen2(n, ges, "");
        }
    }

    /**
     * Method for recursively printing the permutations.
     *
     * @param n   the amount of ones
     * @param ges the total number
     * @param s   the String
     */
    private static void printPermutationen2(int n, int ges, String s) {
        if (s.length() == ges) {
            System.out.println(s);
            return;
        }
        if (ges - n != s.length()) {
            String s1 = s + "0";
            printPermutationen2(n, ges, s1);
        }
        if (n > 0) {
            String s2 = s + "1";
            printPermutationen2(n - 1, ges, s2);
        }

    }

    /**
     * Method for printing all permutations in preorder.
     *
     * @param n   the amount of ones
     * @param ges the total length
     */
    public static void printPermutationen3(int n, int ges) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addLast("");
        while (!deque.isEmpty()) {
            String z = deque.removeFirst();
            int onesInString = countOnesInString(z);
            if (z.length() == ges) {
                if (onesInString == n) {
                    System.out.println(z);
                }
            } else {
                if (onesInString < n) {
                    deque.addLast(z + "1");
                    if (ges - z.length() >= n) {
                        deque.addLast(z + "0");
                    }
                } else {
                    deque.addLast(z + "0");
                }
            }
        }
    }

    /**
     * Method for counting the ones in a given String.
     *
     * @param s the given String
     * @return an int
     */
    private static int countOnesInString(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

}
