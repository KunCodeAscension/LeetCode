package A_hot100;

public class id_34_1 {
    public int[] searchRange(int[] nums, int target) {
        int pre = search(nums, target);
        if (pre >= nums.length || nums[pre] != target) return new int[]{-1, -1};
        int last = search(nums, target + 1) - 1;
        return new int[]{pre, last};
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
