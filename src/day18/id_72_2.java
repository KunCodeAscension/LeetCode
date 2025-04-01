package day18;

// 72. 编辑距离
// https://leetcode.cn/problems/edit-distance/description/
// 解题思路来自：灵茶山艾府
// https://www.bilibili.com/video/BV1TM4y1o7ug?t=486.0

// 把递归改为递推 把递推式子一比一翻译,注意初始化条件

public class id_72_2 {
    private char[] s;
    private char[] t;

    public int minDistance(String word1, String word2) {
        this.s = word1.toCharArray();
        this.t = word2.toCharArray();
        int m = s.length, n = t.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        // 初始化边界条件
        for (int i = 0; i < m; i++) {
            // 初始化边界条件
            dp[i+1][0] = i + 1;
            for (int j = 0; j < n; j++) {
                dp[i+1][j+1] = s[i] == t[j] ? dp[i][j] : Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
            }
        }
        return dp[m][n];
    }
}
