package day9_work;

public class id_111_2 {
    /**
     * 二叉树从上到下递归，每次递归传入深度值，如果深度值+1还是大于ans，说明当前的ans是最小值
     * 不用继续向下递归了
     */

    private int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 0);
        return root != null ? ans : 0;
    }

    private void dfs(TreeNode node, int cnt) {
        if (node == null || ++cnt > ans) {
            return;
        }
        if (node.left == node.right) { // node 是叶子
            ans = Math.min(ans, cnt);
            return;
        }
        dfs(node.left, cnt);
        dfs(node.right, cnt);
    }
}
