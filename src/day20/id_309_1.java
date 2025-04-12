package day20;

public class id_309_1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        // 初始化边界值
        dp[1][1] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i+2][0] = Math.max(dp[i+1][0], dp[i+1][1] + prices[i]);
            dp[i+2][1] = Math.max(dp[i+1][1], dp[i][0] - prices[i]);
        }
        return dp[n+1][0];
    }
}
