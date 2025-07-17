package A_hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class id_128_1 {

    /**
     * 暴力做法
     */
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int Max_count = 0;
        int count = 0;
        int i = 1;
        while (i < nums.length) {
            int cur = nums[i];
            int pre = nums[i - 1];
            if (cur == pre + 1) {
                count++;
                i++;
                Max_count = Math.max(Max_count, count);
            }else if (cur == pre) {
                i++;
            }else{
                count=0;
                i++;
            }
        }
        return Max_count + 1;
    }

    /**
     * Set集合做法
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (Integer x : set) {
            // 当前 i 值不是连续数组的起点
            if (set.contains(x - 1)) {
                continue;
            }
            // 当前 i 是连续数组的起点，不断去找 i+1 i+2......是不是在集合当中
            int y = x + 1;
            while (set.contains(y)) {
                y ++;
            }
            res = Math.max(res, y - x);
        }
        return res;
    }
}
