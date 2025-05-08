package day9_work_2;

public class id_617_1 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        return new TreeNode((root1.val + root2.val),mergeTrees(root1.left, root2.left),mergeTrees(root1.right, root2.right));
    }
}
