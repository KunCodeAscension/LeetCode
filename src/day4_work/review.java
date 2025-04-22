package day4_work;

public class review {

    public int[] searchRange(int[] nums, int target) {
        int left = lower_bound(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = lower_bound(nums, target+1);
        return new int[]{left, right};
    }

    public int lower_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
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
