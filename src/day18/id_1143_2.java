package day18;

public class id_1143_2 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] Text1 = text1.toCharArray();
        char[] Text2 = text2.toCharArray();
        int m = Text1.length;
        int n = Text2.length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0;i < m;i ++){
            for(int j = 0;j < n;j ++){
                dp[i+1][j+1] = Text1[i] == Text2[j] ? dp[i][j] + 1 : Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[m][n];
    }
}
