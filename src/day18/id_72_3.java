package day18;

// 72. 编辑距离
// https://leetcode.cn/problems/edit-distance/description/
// 解题思路来自：灵茶山艾府
// https://www.bilibili.com/video/BV1TM4y1o7ug?t=486.0

// 把递归改为递推 把递推式子一比一翻译,注意初始化条件 二维数组变一维数组

public class id_72_3 {
    private char[] s;
    private char[] t;

    public int minDistance(String word1, String word2) {
        this.s = word1.toCharArray();
        this.t = word2.toCharArray();
        int m = s.length, n = t.length;
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = j;
        }
        // 初始化边界条件
        for (int i = 0; i < m; i++) {
            // 初始化边界条件 先记录左上的值再初始化
            int pre = dp[0];
            dp[0] = i + 1;
            for (int j = 0; j < n; j++) {
                // 需要 左上 左边 和 上边的数 每一次计算都会覆盖左上的值 所以我们需要记录左上的值
                int tem = dp[j+1];
                dp[j+1] = s[i] == t[j] ? pre : Math.min(Math.min(dp[j+1], dp[j]), pre) + 1;
                pre = tem;
            }
        }
        return dp[n];
    }
}
