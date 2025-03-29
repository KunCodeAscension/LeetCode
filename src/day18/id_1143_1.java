package day18;

import java.util.Arrays;

public class id_1143_1 {
    private char[] Text1;
    private char[] Text2;
    private Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        Text1 = text1.toCharArray();
        Text2 = text2.toCharArray();
        memo = new Integer[n][m];
        // 单独初始化每一行
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(n,m);
    }

    public int f(int i,int j){
        if(i<0||j<0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(Text1[i]==Text2[j]){
            memo[i][j] = f(i-1,j-1)+1;
        }
        memo[i][j] = Math.max(f(i-1,j),f(i,j-1));
        return memo[i][j];
    }
}
