package uebung08;

/**
 * Class for testing the permutations.
 *
 * @author Sven Bergmann
 * @version 19.05.2020
 */
public class PermutationenTest {

    public static void main(String[] args) {
        int x = 4;
        System.out.println("Print all permutations from 1 to " + x + ":");
        Permutationen.printPermutationen(x);
        int n = 2;
        int ges = 4;
        System.out.println("Print all permutations with " + n + " ones and a length of " + ges + ":");
        Permutationen.printPermutationen2(n, ges);
        n = 3;
        ges = 5;
        System.out.println("Print all permutations with " + n + " ones and a length of " + ges + ":");
        Permutationen.printPermutationen2(n, ges);
        System.out.println("----");
        n = 2;
        ges = 4;
        System.out.println("Level-Order:");
        System.out.println("Print all permutations with " + n + " ones and a length of " + ges + ":");
        Permutationen.printPermutationen3(n, ges);
    }

}
