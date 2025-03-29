package day17;

import java.util.Arrays;

// 完全背包
public class id_LCR103_2 {
    private int[][] memo;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        memo = new int[n + 1][amount + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, 20000);
        }
        memo[0][0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i]){
                    memo[i+1][j] = memo[i][j];
                }else {
                    memo[i+1][j] = Math.min(memo[i][j], memo[i+1][j - coins[i]] + 1);
                }
            }
        }
        return memo[n][amount] < 20000 ? memo[n][amount] : -1;
    }

}
