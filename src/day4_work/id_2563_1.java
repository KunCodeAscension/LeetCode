package day4_work;

import java.util.Arrays;

// https://leetcode.cn/problems/count-the-number-of-fair-pairs/solutions/2107079/er-fen-cha-zhao-de-ling-huo-yun-yong-by-wplbj/
// 二分法

public class id_2563_1 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = lower_bound(nums,lower-nums[i],i+1);
            if(left == nums.length) continue;
            int right = lower_bound(nums,upper-nums[i] + 1,i+1);
            count += right - left;
        }
        return count;
    }

    public int lower_bound(int[] nums,int target,int begin) {
        int left = begin, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
