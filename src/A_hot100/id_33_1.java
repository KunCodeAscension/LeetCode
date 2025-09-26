package A_hot100;

public class id_33_1 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int end = n - 1;
        int left = 0,right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(isBlue(nums,target,mid,end)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(nums[left] != target || left == n) return -1;
        else return left;
    }

    public boolean isBlue(int[] nums, int target,int i,int end) {
        if(nums[i] > nums[end]) {
            return nums[i] >= target && target > nums[end];
        }else {
            return target > nums[end] || target <= nums[i];
        }
    }
}
