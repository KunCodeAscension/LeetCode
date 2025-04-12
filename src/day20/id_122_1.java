package day20;

import java.util.Arrays;

public class id_122_1 {
    private int[] PRICES;
    private int[][] memo;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.PRICES = prices;
        memo = new int[n][2];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(n-1,0);
    }

    public int dfs(int i,int handle){
        if (i < 0) {
            return handle == 1 ? Integer.MIN_VALUE : 0;
        }
        if (memo[i][handle] != -1) {
            return memo[i][handle]; // 之前计算过
        }
        if(handle == 1){
            // 当天持有股票 可能是上一天啥也不干留下来的 也可能是今天买的
            return memo[i][handle] = Math.max(dfs(i-1,1),dfs(i-1,0)-PRICES[i]);
        }
        // 当天没有股票，可能是上一天也没有，也可能是今天把股票卖了
        return memo[i][handle] = Math.max(dfs(i-1,0),dfs(i-1,1)+PRICES[i]);
    }
}
