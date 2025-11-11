package A_hot100;

public class id_5 {
    /**
     * 动态规划
     */
    public String longestPalindrome(String s) {
        int Max_Length = 0;
        int Max_Left_Index = 0;
        int Max_Right_Index = 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        dp[0][0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    if (i - j + 1 > Max_Length) {
                        Max_Length = i - j + 1;
                        Max_Left_Index = j;
                        Max_Right_Index = i;
                    }
                }
            }
        }
        return s.substring(Max_Left_Index, Max_Right_Index + 1);
    }

    /**
     * 中心法
     */
    public String longestPalindrome1(String s) {
        int Max_Length = 0;
        int Max_Left_Index = 0;
        int Max_Right_Index = 0;
        int length = s.length();
        // 奇
        for (int i = 0; i < length; i++) {
            int left = i, right = i;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left + 1 > Max_Length) {
                Max_Length = right - left + 1;
                Max_Left_Index = left + 1;
                Max_Right_Index = right - 1;
            }
        }
        // 偶
        for (int i = 0; i < length; i++) {
            int left = i, right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left + 1 > Max_Length) {
                Max_Length = right - left + 1;
                Max_Left_Index = left  + 1;
                Max_Right_Index = right  - 1;
            }
        }
        return s.substring(Max_Left_Index, Max_Right_Index + 1);
    }

    public String longestPalindrome2(String s) {
        int Max_Length = 0;
        int Max_Left_Index = 0;
        int Max_Right_Index = 0;
        int length = s.length();
        // 奇
        for (int i = 0; i < length; i++) {
            int left = i, right = i;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left + 1 > Max_Length) {
                Max_Length = right - left + 1;
                Max_Left_Index = left + 1;
                Max_Right_Index = right - 1;
            }
        }
        // 偶
        for (int i = 0; i < length; i++) {
            int left = i, right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left + 1 > Max_Length) {
                Max_Length = right - left + 1;
                Max_Left_Index = left  + 1;
                Max_Right_Index = right  - 1;
            }
        }
        return s.substring(Max_Left_Index, Max_Right_Index + 1);
    }
}
