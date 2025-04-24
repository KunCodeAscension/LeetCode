package day5_work;

public class review {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0,right = n-2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[n-1]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
