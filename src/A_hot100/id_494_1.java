package A_hot100;

import java.util.Arrays;

public class id_494_1 {
    /**
     * 数组中所有为正数的数的和为 a
     * 所有为负数的数的和为 b
     * 数组中所有数的和为 c
     * a - b = c
     * a + b = target
     * a = (c + target) / 2
     */
    public int findTargetSumWays1(int[] nums, int target) {
        int count = Arrays.stream(nums).sum();
        if ((count + target) % 2 != 0) return 0;
        if (target > count || target < -count) return 0;
        int num = (count + target) / 2;
        int[][] dp = new int[nums.length][num+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs(nums,num,nums.length - 1,dp);
    }

    public int dfs(int[] nums, int num,int i,int[][] dp) {
        if (i < 0) return num == 0 ? 1 : 0;
        if (dp[i][num] != -1) return dp[i][num];
        // 只能不选
        if(nums[i] > num) return dp[i][num] = dfs(nums,num,i-1,dp);
        return dp[i][num] = dfs(nums,num,i-1,dp) + dfs(nums,num-nums[i],i-1,dp);
    }

    /**
     * 一比一翻译为递推
     */
    public int findTargetSumWays(int[] nums, int target) {
        int count = Arrays.stream(nums).sum();
        int num = count + target;
        if (num % 2 != 0 || num < 0) return 0;
        num = num / 2;
        int[][] dp = new int[nums.length + 1][num + 1];
        dp[0][0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= num; j++) {
                if(nums[i] > j){
                    dp[i+1][j] = dp[i][j];
                    continue;
                }
                dp[i+1][j] = dp[i][j] + dp[i][j-nums[i]];
            }
        }
        return dp[nums.length][num];
    }
}
