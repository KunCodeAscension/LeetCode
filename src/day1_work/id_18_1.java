package day1_work;

// https://leetcode.cn/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class id_18_1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n - 3; i++) {
            long x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;  // 跳过重复数字
            if (x + nums[i+1] + nums[i+2] + nums[i+3] > target) break;  // 优化
            if (x + nums[n-3] + nums[n-2] + nums[n-1] < target) continue; // 优化
            for (int j = i + 1; j < n - 2; j++) {
                long y = nums[j];
                if(j > i + 1 && y == nums[j - 1] ) continue;  // 跳过重复数字
                if(x + y + nums[j+1] + nums[j+2] > target) break;  // 优化
                if (x + y + nums[n-2] + nums[n-1] < target) continue; // 优化
                int left = j + 1,right = n - 1;
                while (left < right) {
                    if (nums[left] + nums[right] + x + y == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    }
                    else if (nums[left] + nums[right] + x + y < target) {
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
