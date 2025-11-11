package A_hot100;

public class id_3 {
    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[128];
        char[] charArray = s.toCharArray();
        int max = 0;
        int start = 0;
        for (int i = 0; i < charArray.length; i++) {
            pos[charArray[i]]++;
            if(pos[charArray[i]] > 1){
                while(pos[charArray[i]] > 1 && start < i){
                    pos[charArray[start]]--;
                    start++;
                }
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
