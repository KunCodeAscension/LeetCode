package day3_work;

// https://leetcode.cn/problems/minimum-window-substring/submissions/623084561/

public class id_76_1 {
    public String minWindow(String s, String t) {
        int ansLeft = -1;
        int ansRight = s.length();
        char[] sCharArray = s.toCharArray();
        char[] tcharArray = t.toCharArray();
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        int left = 0;
        for (char c : tcharArray) {
            cntT[c] ++;
        }
        for (int i = 0; i < sCharArray.length; i++) {
            cntS[sCharArray[i]]++;
            while(isCovered(cntS, cntT)) {
                if(i - left < ansRight - ansLeft) {
                    ansRight = i;
                    ansLeft = left;
                }
                cntS[sCharArray[left]]--;
                left++;
            }
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}
