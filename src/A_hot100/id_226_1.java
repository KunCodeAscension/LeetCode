package A_hot100;

public class id_226_1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }

    public TreeNode resverTree(TreeNode node) {
        if(node == null) return null;
        TreeNode left = resverTree(node.right);
        TreeNode right = resverTree(node.left);
        return new TreeNode(node.val, left, right);
    }
}
