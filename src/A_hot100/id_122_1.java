package A_hot100;

import java.util.Arrays;

// 买卖股票的最佳时机 II
public class id_122_1 {

    /**
     * 记忆化搜索
     */
    public int maxProfit1(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(prices,0,0,memo);
    }

    public int dfs(int[] prices,int i,int hold,int[][] memo) {
        if(i == prices.length) return 0;
        if(memo[i][hold] != -1) return memo[i][hold];
        // 当前未持有股票 买或者不卖
        if(hold == 0){
            return memo[i][hold] = Math.max(dfs(prices,i+1,0,memo),dfs(prices,i+1,1,memo) - prices[i]);
        }
        // 当前持有股票 卖
        // 如果是最后一天只能卖了
        if (i == prices.length-1) return memo[i][hold] = dfs(prices,i+1,0,memo) + prices[i];
        return memo[i][hold] = Math.max(dfs(prices,i+1,1,memo),dfs(prices,i+1,0,memo) + prices[i]);
    }

    /**
     * 递归改为递推
     */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        // 第一天有股票必须是当天买
        dp[1][1] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            // 当天没有股票 可能是前一天没有 或者是今天卖了
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            // 当天有股票 可能是前一天有 或者是今天刚买
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
        }
        // 最后一天没有持有股票的利润肯定比最后一天持有股票的利润高
        return dp[prices.length][0];
    }

    /**
     * 空间复杂度优化
     */
    public int maxProfit3(int[] prices) {
        // 我们每次只需要用到前一天的数据
        int f0 = 0;
        int f1 = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            int f = f0;
            f0 = Math.max(f0, f1 + prices[i-1]);
            f1 = Math.max(f1, f - prices[i-1]);
        }
        return f0;
    }
}
