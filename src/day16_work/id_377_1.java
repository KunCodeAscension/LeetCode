package day16_work;

import java.util.Arrays;

public class id_377_1 {
    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new int[target+1];
        Arrays.fill(memo, -1);
        return f(nums,target);
    }

    public int f(int[] nums, int target) {
        int num = 0;
        if(target < 0) return 0;
        if(target == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) continue;
            if (memo[target-nums[i]] != -1) num += memo[target-nums[i]];
            else num += f(nums,target-nums[i]);
        }
        return memo[target] = num;
    }

}
