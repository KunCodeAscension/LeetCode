package day16_work;

import java.util.Arrays;

public class id_2466_1 {
    private int[] memo;
    private static final int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new int[high + 1];
        Arrays.fill(memo, -1);
        int count = 0;
        for (int i = low; i <= high; i++) {
            count = (count + dfs(i, zero, one)) % MOD;
        }
        return count;
    }

    public int dfs(int target,int zero,int one){
        if(target==0) return 1;
        if(target<0) return 0;
        if(memo[target]!=-1) return memo[target];
        return memo[target] = (dfs(target-zero,zero,one)+dfs(target-one,zero,one)) % MOD;
    }

}
