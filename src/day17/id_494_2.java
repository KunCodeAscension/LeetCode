package day17;

import java.util.Arrays;

public class id_494_2 {
    private int[][] f;

    public int findTargetSumWays(int[] nums, int target) {
        target += Arrays.stream(nums).sum();
        if(target < 0 || target % 2 != 0) return 0;
        target /= 2;
        int n = nums.length;
        f = new int[n+1][target + 1];
        f[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < target+1; j++){
                if(j < nums[i]){
                    f[i+1][j] = f[i][j];
                }else {
                    f[i+1][j] = f[i][j] + f[i][j - nums[i]];
                }
            }
        }
        return f[n][target];
    }
}
