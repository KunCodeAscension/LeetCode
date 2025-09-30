package A_hot100;

public class id_32_1 {
    /**
     * 动态规划
     *
     * 由题目可知 符合条件的字串最后一位一定是 )
     * 如果 i 为 ) 并且 i-1 为 ( 那么 dp[i] = dp[i-2] + 2
     * 如果 i 为 ) 并且 i-1 为 ) 那么 如果 i - dp[i-1] - 1 也为 ( 那么 dp[i] = dp[i - 1] + dp[i - dp[i-1] - 2] + 2;
     *
     * 由此得出 dp 方程
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i- 1] > 0 && s.charAt(i - dp[i- 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i-1]) >= 2 ? dp[i - dp[i-1] - 2] : 0) + 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
