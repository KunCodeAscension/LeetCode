package day3;

import java.util.HashSet;

public class id_3_2 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (!set.add(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
