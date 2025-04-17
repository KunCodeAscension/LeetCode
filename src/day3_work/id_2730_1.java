package day3_work;

// https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/

import java.util.HashMap;
import java.util.Map;

public class id_2730_1 {
    public int longestSemiRepetitiveSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        if(s.length() == 1) return 1;
        char[] sCharArray = s.toCharArray();
        int left = 0;
        int ans = 0;
        int count = 0;
        int first = 0;
        int pre = 0;
        for (int i = 1; i < sCharArray.length; i++) {
            if (sCharArray[i] == sCharArray[i-1]) {
                pre = first;
                first = i - 1;
                count++;
            }
            if (count >= 2) {
                count--;
                left = pre + 1;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
