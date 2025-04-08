package day19;

/* 动态规划 + 记忆化搜索
    dfs(i) 表示以i为结尾的数组的最长递增子序列的个数
 */

public class id_300_1 {
    public int[] NUMS;
    public int[] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n]; // 本题可以初始化成 0，表示没有计算过
        this.NUMS = nums;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }

    public int dfs(int i){
        if (memo[i] > 0) return memo[i];
        for (int j = 0; j < i; j++) {
            if (NUMS[j] < NUMS[i]) {
                memo[i] = Math.max(memo[i], dfs(j));
            }
        }
        return ++memo[i];  // 加上自身
    }
}

