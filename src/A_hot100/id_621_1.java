package A_hot100;

import java.util.Map;

public class id_621_1 {
    private Map<Character, Integer> map;

    public int leastInterval(char[] tasks, int n) {
        int length = tasks.length;
        int[] cnt = new int[26];
        for (int i = 0; i < length; i++) {
            cnt[tasks[i] - 'A']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i]);
        }
        int res = (max - 1) * (n + 1);
        for (int i = 0; i < 26; i++) {
            if (max == cnt[i]) {
                res++;
            }
        }
        return Math.max(res, length);
    }
}
