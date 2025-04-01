package day18;

import java.util.Arrays;

// 1143. 最长公共子序列
// https://leetcode.cn/problems/longest-common-subsequence/submissions/617826700/
// 解题思路来自：灵茶山艾府
// https://www.bilibili.com/video/BV1TM4y1o7ug?t=1.0

public class id_1143_3 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] Text1 = text1.toCharArray();
        char[] Text2 = text2.toCharArray();
        int m = Text1.length;
        int n = Text2.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for(int i = 0;i < m;i ++){
            int pre = dp[0];  // dp[0] 始终为0不变 表示左上的值
            for(int j = 0;j < n;j ++){
                int tem = dp[j+1];  // 记录当前值作为下一个数计算的左上值
                dp[j+1] = Text1[i] == Text2[j] ? pre + 1 : Math.max(dp[j],dp[j+1]);
                pre = tem;
            }
        }
        return dp[n];
    }
}
