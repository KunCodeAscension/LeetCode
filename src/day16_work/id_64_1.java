package day16_work;

import java.util.Arrays;

/**
 * 空间优化：只用一个数组 或者和 grid共用一个数组
 */

public class id_64_1 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][1] = 0;
        for (int i = 1; i <= m; i++) {
            // 初始化最左侧为最大值，因为不存在
            dp[i][0] = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

}
