package A_hot100;

import java.util.*;

/**
 * 桶排序
 */
public class id_347_1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        int maxCount = Collections.max(map.values());
        List<Integer>[] buckets = new ArrayList[maxCount+1];
        Arrays.setAll(buckets,i -> new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int j = 0;
        for (int i = buckets.length - 1; i >= 0 && j < k; i--) {
            for (Integer integer : buckets[i]) {
                res[j++] = integer;
            }
        }
        return res;
    }
}
