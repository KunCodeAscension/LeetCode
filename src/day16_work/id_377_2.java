package day16_work;

import java.util.Arrays;

public class id_377_2 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i < nums[j]) dp[i] += 0;
                else dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }

}
