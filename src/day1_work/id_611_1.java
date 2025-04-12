package day1_work;

// https://leetcode.cn/problems/valid-triangle-number/description/

import java.util.Arrays;

public class id_611_1 {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n-1; i >= 2; i--) {
            int x = nums[i];
            int left=0,right=i-1;
            while(left<right){
                if(nums[left]+nums[right] > x){
                    count += right - left;
                    right--;
                }else {
                    left++;
                }
            }
        }
        return count;
    }
}
