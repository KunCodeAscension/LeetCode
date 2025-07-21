package A_hot100;

import java.util.Arrays;

public class id_416_1 {
    /**
     * 记忆化搜索
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        int[][] memo = new int[nums.length][sum + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(nums,sum,nums.length-1,memo);
    }

    public boolean dfs(int[] nums,int sum,int i,int[][] memo) {
        if (sum == 0) return true;
        if (i < 0) return false;
        if (memo[i][sum] != -1) return memo[i][sum] == 1;
        // 不选
        if (sum < nums[i]){
            boolean res = dfs(nums, sum, i - 1, memo);
            memo[i][sum] = res ? 1 : 0;
            return res;
        };
        boolean res = dfs(nums, sum, i - 1, memo) || dfs(nums, sum - nums[i], i - 1, memo);
        memo[i][sum] = res ? 1 : 0;
        return res;
    }

    /**
     * 一比一翻译为递推
     */
    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 0; j <= sum; j++) {
                if (nums[i] > j) {
                    dp[i + 1][j] = dp[i][j];
                    continue;
                }
                dp[i + 1][j] = (dp[i][j] == 1 || dp[i][j - nums[i]] == 1) ? 1 : 0;
            }
        }
        return dp[n][sum] == 1;
    }
}
