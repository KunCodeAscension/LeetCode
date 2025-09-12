package A_hot100;

import java.util.Arrays;

public class id_279_1 {
    /**
     * 记忆化搜索
     */
    private int[][] memo;

    public int numSquares1(int n) {
        int num = (int) Math.sqrt(n);
        memo = new int[num + 1][n + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(num,n);
    }

    public int dfs(int i,int n){
        if(i == 0) return n == 0 ? 0 : Integer.MAX_VALUE;
        if(memo[i][n] != -1) return memo[i][n];
        if(i * i > n) return dfs(i - 1, n);
        return memo[i][n] = Math.min(dfs(i - 1,n),dfs(i,n-i * i) + 1);
    }

    /**
     * 一比一翻译为递推
     */
    public int numSquares(int n) {
        int num = (int) Math.sqrt(n);
        int[][] dp = new int[num + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        for(int i = 1; i <= num; i++){
            for(int j = 0; j <= n; j++){
                if(i * i > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i * i] + 1);
            }
        }
        return dp[num][n];
    }
}
