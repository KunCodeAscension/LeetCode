package day1;

import java.util.HashMap;

public class id_1_2 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(length - 1);
        map.put(nums[0],0);
        for (int i = 1; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}

