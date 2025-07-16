package A_hot100;

public class id_647_1 {

    /**
     * 暴力
     */
    public int countSubstrings1(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(isPalindrome(s, i, j)) count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划
     */
    public int countSubstrings2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int ans = 0;
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1] == 1)){
                    dp[i][j] = 1;
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 中心法
     */
    public int countSubstrings3(String s) {
        int n = s.length();
        int count = 0;
        // 奇回文串
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                count++;
            }
        }
        // 偶回文子串
        for (int i = 0;i < n;i++){
            int l = i;
            int r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                count++;
            }
        }
        return count;
    }

    /**
     * 中心法优化一次循环
     * i 是奇数 如 1 l = 0; r = 1;
     * i 是偶数 如 2 l = 1; r = 1;
     */
    public int countSubstrings4(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = (i + 1) / 2;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                count++;
            }
        }
        return count;
    }
}
