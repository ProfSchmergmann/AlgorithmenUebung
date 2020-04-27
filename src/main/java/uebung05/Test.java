package uebung05;

public class Test {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 50);
            System.out.println(x);
            tree.insert(x);
        }
        System.out.println(tree);
        System.out.println("Element count: " + tree.getElementCount());
        System.out.println("Sum: " + tree.getSum());
        System.out.println("Has nodes with one child: " + tree.hasNodesWithOneChild());
        System.out.println("Heigth of this tree: " + tree.getHeight());
        System.out.println("Number of leafs in this tree: " + tree.getLeafCount());


        // Test for Brackets
        String s1 = "(([[]]))";
        String s2 = "([)]";
        String s3 = "([]])";
        String s4 = "(()))";
        String s5 = "(()";
        String s6 = "({[])}";
        String s7 = "aswgerfse";
        System.out.println(s1 + " : " + Brackets.isValid(s1));
        System.out.println(s2 + " : " + Brackets.isValid(s2));
        System.out.println(s3 + " : " + Brackets.isValid(s3));
        System.out.println(s4 + " : " + Brackets.isValid(s4));
        System.out.println(s5 + " : " + Brackets.isValid(s5));
        System.out.println(s6 + " : " + Brackets.isValid(s6));
        System.out.println(s7 + " : " + Brackets.isValid(s7));
    }
}
