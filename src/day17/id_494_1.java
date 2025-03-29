package day17;

import java.util.Arrays;

// p
// s-p
// p-(s-p)=target
// p = (s+target)/2
public class id_494_1 {
    public int[] NUMS;
    private int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        target += Arrays.stream(nums).sum();
        if(target < 0 || target % 2 != 0) return 0;
        target /= 2;
        int n = nums.length;
        memo = new int[n][target + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        this.NUMS = nums;
        return dfs(NUMS.length - 1, target);
    }

    public int dfs(int i,int c){
        if(i < 0){
            return c == 0 ? 1 : 0;
        }
        if(memo[i][c] != -1) return memo[i][c];
        if(c < NUMS[i]){
            return memo[i][c] = dfs(i-1,c);
        }
        return memo[i][c] = dfs(i-1,c) + dfs(i-1,c-NUMS[i]);
    }
}
