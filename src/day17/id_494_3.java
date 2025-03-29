package day17;

import java.util.Arrays;

public class id_494_3 {
    private int[] f;

    public int findTargetSumWays(int[] nums, int target) {
        target += Arrays.stream(nums).sum();
        if(target < 0 || target % 2 != 0) return 0;
        target /= 2;
        int n = nums.length;
        f = new int[target + 1];
        f[0] = 1;
        for(int i : nums){
            for(int j = 0; j < target + 1; j++){
                f[j] += f[j - i];
            }
        }
        return f[target];
    }
}
