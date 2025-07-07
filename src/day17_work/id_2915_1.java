package day17_work;

import java.util.Arrays;
import java.util.List;

public class id_2915_1 {
    /**
     * 记忆化搜索
     */
    private int[][] memo;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        memo = new int[nums.size()][target+1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        int result = f(nums, target, nums.size() - 1);
        return result < 0 ? -1 : result;
    }

    public int f(List<Integer> nums, int target,int i) {
        if(i < 0) return target == 0 ? 0 : Integer.MIN_VALUE;
        if(memo[i][target] != -1) return memo[i][target];
        if(target < nums.get(i)) return f(nums, target, i-1);
        return memo[i][target] = Math.max(f(nums, target - nums.get(i), i - 1) + 1, f(nums, target, i-1));
    }

    /**
     * 一比一翻译为递推
     */
    public int lengthOfLongestSubsequence2(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()+1][target+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < target + 1; j++) {
                if(j < nums.get(i)) dp[i+1][j] = dp[i][j];
                else dp[i+1][j] = Math.max(dp[i][j], dp[i][j-nums.get(i)]+1);
            }
        }
        return dp[nums.size()][target] < 0 ? -1 : dp[nums.size()][target];
    }

    /**
     * 空间优化
     */
    public int lengthOfLongestSubsequence3(List<Integer> nums, int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        f[0] = 0;
        for (int x : nums) {
            for (int j = target; j >= x; j--) {
                f[j] = Math.max(f[j], f[j - x] + 1);
            }
        }
        return f[target] > 0 ? f[target] : -1;
    }
}
