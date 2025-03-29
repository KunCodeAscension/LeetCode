package day17;

import java.util.Arrays;

public class id_LCR103_3 {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        Arrays.fill(f, 20000);
        f[0] = 0;
        for(int x : coins){
            for(int j = x; j <= amount; j++){
                f[j] = Math.min(f[j], f[j - x] + 1);
            }
        }
        return f[amount] < 20000 ? f[amount] : -1;
    }
}
