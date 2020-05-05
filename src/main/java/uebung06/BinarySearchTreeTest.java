package uebung06;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 50);
//            System.out.print(x + ", ");
            tree.insert(x);
        }
//        for (int i = 0; i < 50; i++) {
//            System.out.println(i + ": " + tree.contains(i));
//        }
        System.out.println("Preorder: ");
        tree.printPreorder();
        System.out.println("ArrayList of leaves: ");
        System.out.println(tree.getLeaves());
        int x = 0;
        System.out.println("ArrayList of element at level: " + x);
        System.out.println(tree.getElementsInLevel(x));
        x = 2;
        System.out.println("ArrayList of element at level: " + x);
        System.out.println(tree.getElementsInLevel(x));
    }
}
