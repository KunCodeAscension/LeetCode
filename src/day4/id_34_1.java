package day4;

public class id_34_1 {
    public int[] searchRange(int[] nums, int target) {
        int start = lower_bound(nums, target);
        if(start == nums.length || nums[start] != target) return new int[]{-1,-1};
        int end = lower_bound(nums,target+1) -1;
        return new int[]{start,end};
    }

    public int lower_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int lower_bound2(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
}
