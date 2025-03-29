package day3;

public class id_3_3 {
    public int lengthOfLongestSubstring(String s) {
        char[] characters = s.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128];
        for (int right = 0; right < characters.length; right++) {
            char currentChar = characters[right];
            cnt[currentChar]++;
            while (cnt[currentChar] > 1) {
                cnt[characters[left]]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
