package uebung12;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode (TreeNode from) {
        this.value = from.value;
		if (from.left!= null) {
		    this.left = new TreeNode(from.left);
        }
		if (from.right!= null) {
		    this.right = new TreeNode(from.right);
        }
    }
}
