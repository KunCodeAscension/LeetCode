package day20;

import java.util.Arrays;

public class id_122_2 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        // 初始化边界值
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i+1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i+1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[n][0];
    }
}
