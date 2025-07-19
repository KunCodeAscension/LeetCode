package A_hot100;

import java.util.*;

public class id_448_1 {
    /**
     * 下标标记
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int[] app = new int[n+1];
        for (int num : nums) {
            app[num] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (app[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
