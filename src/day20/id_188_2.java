package day20;

import java.util.Arrays;

public class id_188_2 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n+1][k + 2][2];
        for (int[][] mat : f) {
            for (int[] row : mat) {
                Arrays.fill(row, Integer.MIN_VALUE / 2); // 初始化 j < 0 and i < 0 && handle = 1 的地方为负无穷表示不合法 除以2为了防止越界
            }
        }
        for (int i = 1; i <= k+1; i++) {
            f[0][i][0] = 0;  // 初始化所有 i = 0 && handle = 0 的地方为0  表示第0天结束以后，未持有股票的最大利润为0
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k+1; j++) {
                f[i+1][j][0] = Math.max(f[i][j][0], f[i][j-1][1] + prices[i]);
                f[i+1][j][1] = Math.max(f[i][j][1], f[i][j][0] - prices[i]);
            }
        }
        return f[n][k+1][0];
    }
}
