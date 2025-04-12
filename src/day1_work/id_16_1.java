package day1_work;

import java.util.Arrays;

// https://leetcode.cn/problems/3sum-closest/description/

public class id_16_1 {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i + 1,k = n - 1;
            while (j < k) {
                int sum = x + nums[j] + nums[k];
                int abs = Math.abs(x + nums[j] + nums[k] - target);
                if (abs < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum < target) {
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return res;
    }
}
