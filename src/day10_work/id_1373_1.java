package day10_work;

// 后续遍历传递最小值 最大值 和

public class id_1373_1 {
    private int MAX = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return MAX;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int x = root.val;
        if(x >= right[0] || x <= left[1]){
            return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int s =  x + left[2] + right[2];
        MAX = Math.max(MAX,s);
        return new int[] {Math.min(left[0], x), Math.max(x, right[1]), s};
    }
}
