package day1_work;

// https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/description/

import java.util.List;

public class id_2824_1 {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        nums.sort(Integer::compare);
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = i,right = n - 1;
            while (left < right) {
                if (nums.get(left) + nums.get(right) < target) {
                    count++;
                    right--;
                }else if (nums.get(left) + nums.get(right) >= target) {
                    right --;
                }
            }
        }
        return count;
    }
}
