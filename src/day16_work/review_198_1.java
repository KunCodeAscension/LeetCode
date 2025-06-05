package day16_work;

import java.util.Arrays;

/**
 * 动态规划 从后向前偷 偷完一家就不能偷下一家，必须跳过一家
 * 记忆化搜索
 */

public class review_198_1 {
    private int[] nums;
    private int[] memo;

    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        this.nums = nums;
        return f(n - 1);
    }

    public int f(int i){
        if(i<0) return 0;
        if(memo[i] != -1) return memo[i];
        int result = Math.max(f(i-1) , f(i-2) + nums[i]);
        memo[i] = result;
        return result;
    }
}
