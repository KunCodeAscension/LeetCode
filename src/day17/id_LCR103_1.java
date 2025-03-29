package day17;

import java.util.Arrays;

// 完全背包
public class id_LCR103_1 {
    private int[] COINS;
    private int AMOUNT;
    private int[][] memo;

    public int coinChange(int[] coins, int amount) {
        this.AMOUNT = amount;
        this.COINS = coins;
        int n = coins.length;
        memo = new int[n][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(n-1,AMOUNT) < 20000 ? dfs(n-1,AMOUNT) : -1;
    }

    public int dfs(int i,int c){
        if(i < 0){
            return c == 0 ? 0 : 20000;
        }
        if(memo[i][c] != -1) return memo[i][c];
        if(c < COINS[i]){
            return memo[i][c] = dfs(i - 1,c);
        }else{
            return memo[i][c] = Math.min(dfs(i-1,c),dfs(i,c-COINS[i]) + 1);
        }
    }

}
