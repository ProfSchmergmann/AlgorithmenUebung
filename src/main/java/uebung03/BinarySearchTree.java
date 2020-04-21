package uebung03;

public class BinarySearchTree {
    private TreeNode root;

    public boolean contains(int data) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.value == data) {
                return true;
            }
            if (temp.value > data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;

    }

    // This method mainly calls insertRec()
    boolean insert(int key) {
        try {
            root = insertRec(root, key);
        } catch (ElementFoundException e) {
            return false;
        }
        return true;
    }

    /* A recursive function to insert a new key in BST */
    TreeNode insertRec(TreeNode root, int key) throws ElementFoundException {

        if (this.contains(key)) {
            throw new ElementFoundException("Element " + key + " is already in this SearchTree!");
        }

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.value)
            root.left = insertRec(root.left, key);
        else if (key > root.value)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 50);
            System.out.println(x);
            tree.insert(x);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(i + ": " + tree.contains(i));
        }
    }

}
