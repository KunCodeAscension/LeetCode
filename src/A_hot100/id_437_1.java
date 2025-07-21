package A_hot100;

public class id_437_1 {
    /**
     * 以每个节点作为根节点开始寻找
     */
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + dfs(root, targetSum);
    }

    public int dfs(TreeNode root, long curSum) {
        if(root == null) return 0;
        curSum -= root.val;
        int count = curSum == 0 ? 1 : 0;
        count += dfs(root.left, curSum);
        count += dfs(root.right, curSum);
        return count;
    }
}
