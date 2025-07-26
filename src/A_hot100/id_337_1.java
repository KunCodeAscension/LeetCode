package A_hot100;

import java.util.HashMap;
import java.util.Map;

public class id_337_1 {
    Map<TreeNode, Integer[]> memo = new HashMap<>();

    /**
     * 记忆化搜索
     */
    public int rob1(TreeNode root) {
        return dfs(root,1);
    }

    public int dfs(TreeNode root, int flag) {
        if (root == null) return 0;
        // 确保每个节点的两种状态都被初始化
        memo.putIfAbsent(root, new Integer[]{-1, -1});
        Integer[] integers = memo.get(root);
        if (integers[flag] != -1) {
            return integers[flag];
        }
        if (flag == 1) {
            // 可选时：比较选和不选的最大值
            int left_1 = dfs(root.left, 1);
            int right_1 = dfs(root.right, 1);
            int left_0 = dfs(root.left, 0);
            int right_0 = dfs(root.right, 0);
            // 不选当前节点
            int max_0 = Math.max(left_1, left_0) + Math.max(right_1, right_0);
            // 选当前节点
            int max_1 = left_0 + right_0 + root.val;
            integers[flag] = Math.max(max_1, max_0);
        } else {
            // 不可选时：只能不选
            integers[flag] = dfs(root.left, 1) + dfs(root.right, 1);
        }
        return integers[flag];
    }

    /**
     * 树形DP
     */
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode node){
        //[选,不选]
        if (node == null) return new int[]{0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        // 不选左右节点 说明只能选择了当前节点
        int rob = left[1] + right[1] + node.val;
        // 选了左右节点，说明当前节点不能选
        int notrob = Math.max(left[1],left[0]) + Math.max(right[1],right[0]);
        return new int[]{rob, notrob};
    }
}
