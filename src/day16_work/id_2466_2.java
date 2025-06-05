package day16_work;

import java.util.Arrays;

public class id_2466_2 {
    private static final int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        int count = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] = dp[i - zero];
            if (i >= one)  dp[i] = (dp[i] + dp[i - one]) % MOD;
            if (i >= low)  count = (count + dp[i]) % MOD;
        }
        return count;
    }

}
