package day3_work;

import java.util.Arrays;

public class id_2962_1 {
    public long countSubarrays(int[] nums, int k) {
        Arrays.sort(nums);
        int mx = nums[nums.length - 1];
        long ans = 0;
        int left = 0;
        int count = 0;
        for (int num : nums) {
            if (num == mx) {
                count++;
            }
            while(count == k) {
                if(nums[left] == mx) {
                    count--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
