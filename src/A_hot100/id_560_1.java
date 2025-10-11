package A_hot100;

import java.util.HashMap;
import java.util.Map;

public class id_560_1 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0;
        int ans = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            int key = s - k;
            ans += map.getOrDefault(key, 0);
            map.merge(s, 1, Integer::sum);
        }
        return ans;
    }
}
