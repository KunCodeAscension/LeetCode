package A_hot100;

import java.util.Arrays;

public class id_322_1 {

    /**
     * 记忆化搜索
     */
    public int coinChange1(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        int result = dfs(coins, amount, coins.length - 1,memo);
        return result >= 200000 ? -1 : result;
    }

    public int dfs(int[] coins, int amount ,int i,int[][] memo) {
        if (amount == 0) return 0;
        if (i < 0) return 200000;
        if (memo[i][amount] != -1) return memo[i][amount];
        // 只能不选
        if(coins[i] > amount){
            return memo[i][amount] = dfs(coins, amount, i - 1,memo);
        }
        // 选 或者 不选
        return memo[i][amount] = Math.min(dfs(coins,amount-coins[i],i,memo) + 1, dfs(coins,amount,i-1,memo));
    }

    /**
     * 一比一翻译为递推
     */
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        // 初始化边界条件 i = 0 amount = 0 结果为0 i = 0 amount 不为0 结果为 200000
        int[] nums = dp[0];
        Arrays.fill(nums, 200000);
        dp[0][0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                // 只能不选
                if (coins[i] > j) {
                    dp[i + 1][j] = dp[i][j];
                    continue;
                }
                dp[i+1][j] = Math.min(dp[i][j], dp[i+1][j-coins[i]]+1);
            }
        }
        return dp[coins.length][amount] >= 200000 ? -1 : dp[coins.length][amount];
    }
}
