package day5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class id_162_1 {
    public int findPeakElement(int[] nums) {
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int x = 0;
        int max = nums[nums.length - 1];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if(nums2[left] == max) {
                x = left;
            }if(nums2[right] == max) {
                x = right;
            }
            left++;
            right--;
        }
        return x;
    }
}

