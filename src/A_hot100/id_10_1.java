package A_hot100;

public class id_10_1 {
    /**
     * aaaa
     * aaa*
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j = 2;j < n + 1;j ++)
            dp[0][j] = dp[0][j-2] && p.charAt(j - 1) == '*';
        for(int i = 1;i < m + 1;i++){
            for(int j = 1;j < n + 1;j++){
                dp[i][j] = p.charAt(j - 1) == '*' ? (dp[i][j-2]) || (dp[i-1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) : dp[i-1][j-1] && ((p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.'));
            }
        }
        return dp[m][n];
    }
}
