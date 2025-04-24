package day5_work;

// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/solutions/2131553/zhi-yao-ni-hui-153-jiu-neng-kan-dong-pyt-qqc6/

public class id_154_1 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 2;
        int end = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right+1]) {
                left = mid + 1;
            }else if(nums[mid] < nums[right+1]) {
                right = mid - 1;
            }else {
                right --;
            }
        }
        return nums[left];
    }
}

// 3 1 2 3 3 3 当 mid = end 的时候无法判断mid是在最小值的左边还是右边，所以在相等的时候
// 可以去掉最后一个数，如果最后一个数正好是最小值，mid也是最小值，如果不是最小值正好缩小了范围