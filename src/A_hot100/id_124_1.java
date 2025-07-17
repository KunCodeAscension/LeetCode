package A_hot100;

public class id_124_1 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode Node) {
        if (Node == null) {
            return 0;
        }
        int left = dfs(Node.left) + Node.val;
        int right = dfs(Node.right) + Node.val;
        int path_max = Math.max(left+right-Node.val, Math.max(right, Math.max(max, left)));
        max = Math.max(path_max, Node.val);
        return Math.max(Node.val, Math.max(left, right));
    }
}
