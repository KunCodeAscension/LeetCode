package day3_work;

// https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class id_2958_1 {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        Map<Integer,Integer> sum = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum.merge(nums[i],1,Integer::sum);
            while (sum.get(nums[i]) > k) {
                sum.merge(nums[left++],-1,Integer::sum);
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
