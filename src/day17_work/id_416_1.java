package day17_work;

import java.util.Arrays;

public class id_416_1 {
    /**
     * 记忆化搜搜
     */
    private int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        memo = new int[nums.length][(sum / 2) + 1];
        for(int[] num : memo){
            Arrays.fill(num, -1);
        }
        return f(nums,sum / 2,nums.length - 1);
    }

    public boolean f(int[] nums,int target,int i){
        if(i < 0) return target == 0;
        if(memo[i][target] != -1) return memo[i][target] == 1;
        if(target < nums[i]) return f(nums, target, i - 1);
        boolean result = f(nums, target, i - 1) || f(nums, target - nums[i], i - 1);
        memo[i][target] = result ? 1 : 0;
        return result;
    }

    /**
     * 一比一翻译为递推
     */

}
