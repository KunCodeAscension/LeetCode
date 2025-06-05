package day16_work;

import java.util.Arrays;

public class review_198_2 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        Arrays.fill(dp, 0);
        for(int i = 0;i<nums.length;i++){
            dp[i+2] = Math.max(dp[i+1], nums[i] + dp[i+2]);
        }
        return dp[n];
    }

}
