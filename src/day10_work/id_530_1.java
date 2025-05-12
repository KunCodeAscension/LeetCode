package day10_work;

public class id_530_1 {
    private int pre = Integer.MAX_VALUE;

    private int MIN = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return MIN;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        MIN = Math.min(MIN, Math.abs(root.val - pre));
        pre = root.val;
        dfs(root.right);
    }

}
