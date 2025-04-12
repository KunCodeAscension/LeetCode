package day20;

import java.util.Arrays;

public class id_188_1 {
    private int[] prices;
    private int[][][] memo;

    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        int n = prices.length;
        memo = new int[n][k + 1][2];
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1); // -1 表示还没有计算过
            }
        }
        return dfs(n - 1, k, 0);
    }

    public int dfs(int i, int j, int hold) {
        if(j < 0) return Integer.MIN_VALUE / 2;
        if(i < 0) return hold == 0 ? Integer.MIN_VALUE / 2 : 0;
        if(memo[i][j][hold] != -1) return memo[i][j][hold];
        if(hold == 1) return memo[i][j][hold] = Math.max(dfs(i - 1, j, 1), dfs(i-1, j - 1, 0) - prices[i]);
        return memo[i][j][hold] = Math.max(dfs(i-1,j,0), dfs(i-1,j,1) + prices[i]);
    }
}
