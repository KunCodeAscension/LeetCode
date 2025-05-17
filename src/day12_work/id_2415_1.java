package day12_work;

public class id_2415_1 {

    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }

    public void dfs(TreeNode left, TreeNode right,int depth) {
        if (left == null && right == null) {
            return;
        }
        if (left != null && depth % 2 == 1) {
            int val = left.val;
            left.val = right.val;
            right.val = val;
        }
        dfs(left.left, right.right, depth + 1);
        dfs(right.left, left.right, depth + 1);
    }

}
