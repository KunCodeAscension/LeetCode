package A_hot100;

import java.util.ArrayList;
import java.util.List;

public class id_438_1 {
    public List<Integer> findAnagrams(String s, String p) {
        int Slen = s.length();
        int Plen = p.length();
        List<Integer> res = new ArrayList<>();
        if(Slen == 0 || Plen == 0) return res;
        if(Plen > Slen) return res;
        char[] PcharArray = p.toCharArray();
        char[] ScharArray = s.toCharArray();
        int[] Pcharnums = new int[26];
        for (char c : PcharArray) {
            Pcharnums[c - 'a']++;
        }
        int[] nums = new int[26];
        for (int i = 0; i < Plen - 1; i++) {
            nums[ScharArray[i] - 'a']++;
        }
        int left = 0;
        while (left < Slen - Plen) {
            nums[ScharArray[left+Plen-1] - 'a']++;
            if (isSame(nums,Pcharnums)){
                res.add(left);
            }
            nums[ScharArray[left] - 'a']--;
            left++;
        }
        return res;
    }

    public boolean isSame(int[] nums,int[] Pcharnums){
        for(char a = 'a'; a <= 'z'; a++){
            if(nums[a - 'a'] != Pcharnums[a - 'a']){
                return false;
            }
        }
        return true;
    }
}
