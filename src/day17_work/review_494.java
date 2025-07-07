package day17_work;

import java.util.Arrays;

/**
 * 我们设取正的个数和为 p
 * 那么取反的个数和为 n - p
 * 所以 p - (n - p) = target 化简之后为 2p = target + n
 * 所以 p = (target + n) / 2
 */
public class review_494 {

    /**
      记忆化搜搜
     */
    private int[][] memo;

    public int findTargetSumWays1(int[] nums, int target) {
        target += Arrays.stream(nums).sum();
        if(target<0 || target % 2 != 0) return 0;
        target /= 2;
        int n = nums.length;
        memo = new int[n][target + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        // 当前问题转化为 0 1 背包问题 背包总容量为 target（正数和） 对于nums中的数 取反或者不取反
        // max(dfs(i-1,c),dfs(i-1,c-w[i]) + v[i])
        return dfs(target,n-1,nums);
    }

    public int dfs(int sums,int i,int[] nums){
        if(i < 0) return sums == 0 ? 1 : 0;
        if(memo[i][sums] != -1) return memo[i][sums];
        // 如果剩余背包容量不够，只能不选
        if(sums < nums[i]) return dfs(sums,i - 1,nums);
        // 选或者不选
        return memo[i][sums] = dfs(sums - nums[i],i-1,nums) + dfs(sums,i - 1,nums);
    }

    /**
     * 一比一改成递推
     */
    public int findTargetSumWays2(int[] nums, int target) {
        target += Arrays.stream(nums).sum();
        if(target<0 || target % 2 != 0) return 0;
        target /= 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=target;j++){
                if(j < nums[i]){
                    dp[i+1][j] = dp[i][j];
                }else {
                    dp[i+1][j] = dp[i][j] + dp[i][j - nums[i]];
                }
            }
        }
        return dp[n][target];
    }

    /**
     * 简化为一维数组
     */
    public int findTargetSumWays(int[] nums, int target) {
        target += Arrays.stream(nums).sum();
        if(target<0 || target % 2 != 0) return 0;
        target /= 2;
        int[] f = new int[target + 1];
        f[0] = 1;
        for(int i : nums){
            /*
             * 对于原来 i行    1 2 3 5 6 7 9
             *        i+1 行 1 2 3 5 6 7 9
             *        f[i+1][c] = f[i][c] + f[i][c - w[i]]
             *        这样计算i + 1 行计算的结果并不会影响后面
             * 但是当我们简化到只有一维数组的时候 前面计算的的结果会影响到后面
             * 所以我们需要倒序遍历
             */
            for(int j= target;j >= i;j--){
                f[j] += f[j - i];
            }
        }
        return f[target];
    }

}
