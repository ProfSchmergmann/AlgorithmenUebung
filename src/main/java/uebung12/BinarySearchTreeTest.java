package uebung12;

import java.util.Arrays;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        // Konstruktion des Baumes aus Aufgabe 4
        int[] preOrderList = new int[]{55, 42, 4, 5, 96, 67, 63, 68, 87, 99};
        System.out.println(Arrays.toString(preOrderList));
        BinarySearchTree tree = new BinarySearchTree(preOrderList);
        System.out.println("Preorder: ");
        tree.printPreorder();
        System.out.println("PreorderList: ");
        System.out.println(tree.getPreorderList());
        System.out.println("Copy root of this tree: ");
        TreeNode t1 = new TreeNode(tree.root);
        tree.root = t1;
        System.out.println("Preorder of this tree with the copied root: ");
        tree.printPreorder();
        System.out.println("Copy the first tree and get the preorder: ");
        BinarySearchTree tree2 = new BinarySearchTree(tree);
        tree2.printPreorder();
    }
}
