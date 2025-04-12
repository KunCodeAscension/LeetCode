package day20;

import java.util.Arrays;

public class id_188_3 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] f = new int[k + 2][2];
        for (int[] mat : f) {
            Arrays.fill(mat, Integer.MIN_VALUE / 2);
        }
        for (int i = 1; i <= k+1; i++) {
            f[i][0] = 0;
        }
        for (int price : prices) {
            for (int j = 1; j <= k+1; j++) {
                f[j][0] = Math.max(f[j][0], f[j-1][1] + price);
                f[j][1] = Math.max(f[j][1], f[j][0] - price);
            }
        }
        return f[k+1][0];
    }
}
