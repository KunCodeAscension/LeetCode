package day4_work;

// https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/submissions/623895952/

public class id_2529_1 {
    public int maximumCount(int[] nums) {
        int start = lower_zero(nums, 0);
        if (start == nums.length) {
            return start;
        }
        if(nums[start] == 0){
            int end = lower_zero(nums, 1);
            return Math.max(start, nums.length - end);
        }else {
            return Math.max(start, nums.length - start);
        }
    }

    public int lower_zero(int[] nums,int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left) /2;
            if(nums[mid] >= target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
