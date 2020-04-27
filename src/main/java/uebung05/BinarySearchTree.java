package uebung05;

/**
 * Class BinarySearchTree for saving some elements.
 *
 * @author Sven Bergmann
 * @version 27.04.2020
 */
public class BinarySearchTree {
    private TreeNode root;

    /**
     * Method for checking if the tree contains the data.
     *
     * @param data the data
     * @return true or false
     */
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
     * @param data the data to be saved
     * @return true, if the data has been saved,
     * false, if the data was already in the tree.
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
     * This method should return a String representation of the given tree.
     *
     * @return a String
     */
    public String toString() {
        return toString(root);
    }

    /**
     * Private Method for recursively building a String.
     *
     * @param treeNode the node
     * @return a String
     */
    private String toString(TreeNode treeNode) {
        if (treeNode == null) {
            return "";
        }
        String res = "";
        if (!(toString(treeNode.left).isEmpty())) {
            res += toString(treeNode.left) + ",";
        }
        res += treeNode.value;
        if (!(toString(treeNode.right).isEmpty())) {
            res += "," + toString(treeNode.right);
        }
        return res;
    }

    /**
     * Method to return the element count.
     *
     * @return the element count as int
     */
    public int getElementCount() {
        return getElementCount(root);
    }

    /**
     * Method for recursively counting the elements.
     *
     * @param treeNode the node
     * @return the count as int
     */
    private int getElementCount(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return getElementCount(treeNode.left) + getElementCount(treeNode.right) + 1;
    }

    /**
     * Method to return the sum.
     *
     * @return the sum as int
     */
    public int getSum() {
        return getSum(root);
    }

    /**
     * Method for recursively summing up the elements.
     *
     * @param treeNode the node
     * @return the sum as int
     */
    private int getSum(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return getSum(treeNode.left) + getSum(treeNode.right) + treeNode.value;
    }

    /**
     * Method to return the height of this tree.
     *
     * @return the height as int
     */
    public int getHeight() {
        return getHeight(root);
    }

    /**
     * Method for recursively computing the height of this tree.
     *
     * @param treeNode the node
     * @return the height as int
     */
    private int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int depthLeft = getHeight(treeNode.left);
            int depthRight = getHeight(treeNode.right);

            if (depthLeft > depthRight) {
                return depthLeft + 1;
            } else {
                return depthRight + 1;
            }
        }
    }

    /**
     * Method to return the leaf count.
     *
     * @return leaf count as int
     */
    public int getLeafCount() {
        return getLeafCount(root);
    }

    /**
     * Private metod for recursively counting the leafs.
     *
     * @param treeNode the node
     * @return the leafs as int
     */
    private int getLeafCount(TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            return 1;
        } else if (treeNode.left != null && treeNode.right != null) {
            return getLeafCount(treeNode.left) + getLeafCount(treeNode.right);
        } else if (treeNode.left != null) {
            return getLeafCount(treeNode.left);
        } else {
            return getLeafCount(treeNode.right);
        }
    }

    /**
     * Method to check if the tree has nodes with just one child.
     *
     * @return true or false
     */
    public boolean hasNodesWithOneChild() {
        return hasNodesWithOneChild(root);
    }

    /**
     * Method to recursively search the tree for nodes with one child.
     *
     * @param treeNode the node
     * @return true or false
     */
    private boolean hasNodesWithOneChild(TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            return false;
        } else if (treeNode.left != null && treeNode.right == null) {
            return true;
        } else if (treeNode.left == null) {
            return true;
        } else {
            return hasNodesWithOneChild(treeNode.left) || hasNodesWithOneChild(treeNode.right);
        }
    }

}

