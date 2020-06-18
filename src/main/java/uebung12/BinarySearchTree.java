package uebung12;

import java.util.ArrayList;

public class BinarySearchTree {
    TreeNode root;
    private ArrayList<Integer> integerArrayList;

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

    /**
     * @param data Datensatz
     * @return true: Datensatz wurde eingefuegt; false: Datensatz war schon
     * vorhanden.
     */
    public boolean insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return true;
        }


        TreeNode temp = root;
        while (temp.value != data) {
            if (temp.value > data) {
                if (temp.left == null) {
                    temp.left = new TreeNode(data);
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new TreeNode(data);
                    return true;
                }
                temp = temp.right;
            }
        }
        return false;

    }

    /**
     * Method for printing the preordered tree.
     */
    public void printPreorder() {
        this.printPreorder(this.root);
        System.out.println("");
    }

    /**
     * Recursive method for helping to print the tree in preorder.
     *
     * @param treeNode the node
     */
    private void printPreorder(TreeNode treeNode) {
        System.out.print(treeNode.value + ", ");

        if (treeNode.left != null) {
            this.printPreorder(treeNode.left);
        }

        if (treeNode.right != null) {
            this.printPreorder(treeNode.right);
        }
    }

    /**
     * Method for returning an ArrayList of the values of the leaf nodes.
     * By calling this method it automatically overwrites the old ArrayList.
     *
     * @return an ArrayList of Integer
     */
    public ArrayList<Integer> getLeaves() {
        this.integerArrayList = new ArrayList<>();
        this.addLeafElements(this.root);
        return this.integerArrayList;
    }

    /**
     * Private function for recursively adding a leaf value.
     *
     * @param treeNode the node
     */
    private void addLeafElements(TreeNode treeNode) {
        if (treeNode.left != null && treeNode.right != null) {
            this.integerArrayList.add(treeNode.value);
        }
        if (treeNode.left != null) {
            this.addLeafElements(treeNode.left);
        }
        if (treeNode.right != null) {
            this.addLeafElements(treeNode.right);
        }
    }

    /**
     * Method for returning the values in the specific level.
     *
     * @param level the given level
     * @return an ArrayList of Integer
     */
    public ArrayList<Integer> getElementsInLevel(int level) {
        this.integerArrayList = new ArrayList<>();
        int count = 0;
        this.addLevelElements(this.root, level, count);
        return this.integerArrayList;
    }

    /**
     * This method is for recursively adding the element values to the list.
     *
     * @param treeNode the node
     * @param level    the level
     * @param count    the count
     */
    private void addLevelElements(TreeNode treeNode, int level, int count) {
        if (count == level) {
            this.integerArrayList.add(treeNode.value);
        }
        if (count < level) {
            if (treeNode.left != null) {
                this.addLevelElements(treeNode.left, level, count + 1);
            }
            if (treeNode.right != null) {
                this.addLevelElements(treeNode.right, level, count + 1);
            }
        }
    }

    /**
     * Constructor for creating a BinarySearchTree with the given list in preorder.
     *
     * @param preorderList the preordered list of ints
     */
    public BinarySearchTree(int[] preorderList) {
        for (int i : preorderList) {
            this.insert(i);
        }
    }

    /**
     * Copy-Constructor which only copies the root element.
     * @param from the tree to copy from
     */
    public BinarySearchTree(BinarySearchTree from) {
        this.root = from.root;
    }

    /**
     * Method for returning the tree in preorder.
     *
     * @return an ArrayList of the preordered tree
     */
    public ArrayList<Integer> getPreorderList() {
        ArrayList<Integer> temp = new ArrayList<>();
        return this.getPreorderList(root, temp);
    }

    /**
     * Private method for recursively adding the preorder elements.
     * @param treeNode the current node
     * @param temp the ArrayList
     * @return an Integer ArrayList
     */
    private ArrayList<Integer> getPreorderList(TreeNode treeNode, ArrayList<Integer> temp) {
        temp.add(treeNode.value);
        if (treeNode.left != null) {
            ArrayList<Integer> tempL = new ArrayList<>();
            temp.addAll(this.getPreorderList(treeNode.left, tempL));
        }

        if (treeNode.right != null) {
            ArrayList<Integer> tempR = new ArrayList<>();
            temp.addAll(this.getPreorderList(treeNode.right, tempR));
        }
        return temp;
    }

}