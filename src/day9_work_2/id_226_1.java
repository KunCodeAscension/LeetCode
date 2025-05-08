package day9_work_2;

public class id_226_1 {
    // 简单的反转列表
    public TreeNode invertTree(TreeNode root) {
        reverseTree(root);
        return root;
    }

    public void reverseTree(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        reverseTree(root.left);
        reverseTree(root.right);
    }
}
