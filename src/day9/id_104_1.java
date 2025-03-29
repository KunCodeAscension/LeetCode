package day9;

public class id_104_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(5,new TreeNode(6),new TreeNode(7)),new TreeNode(9));
        new id_104_1().maxDepth(root);
    }
}
