package day17_work;

import java.util.Arrays;

public class review_322 {

    /**
     * 记忆化搜搜
     */
    private int[][] memo;

    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        memo = new int[n][amount+1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        int result = dfs(coins, amount, n - 1);
        return result >= 200000 ? -1 : result;
    }

    public int dfs(int[] coins, int amount,int i) {
        if(i < 0) return amount == 0 ? 0 : 200000;
        if(memo[i][amount] != -1) return memo[i][amount];
        if(amount < coins[i]) return dfs(coins, amount,i-1);
        return memo[i][amount] = Math.min(dfs(coins, amount-coins[i], i) + 1,dfs(coins, amount, i-1));
    }

    /**
     * 一比一翻译为递推
     */
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount+1];
        Arrays.fill(dp[0], 200000);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < amount+1; j++) {
                if (j < coins[i]) {
                    dp[i + 1][j] = dp[i][j];
                }else {
                    dp[i + 1][j] = Math.min(dp[i + 1][j-coins[i]] + 1, dp[i][j]);
                }
            }
        }
        return dp[n][amount] >= 200000 ? -1 : dp[n][amount];
    }

    /**
     * 简化为一维数组
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 200000);
        dp[0] = 0;
        for(int i : coins) {
            for (int j = i; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-i] + 1);
            }
        }
        return dp[amount] >= 200000 ? -1 : dp[amount];
    }
}
