package day1_work;

import java.util.List;

public class id_2824_2 {
    public int countPairs(List<Integer> nums, int target) {
        nums.sort(Integer::compare);
        int count = 0;
        int n = nums.size();
        int left = 0, right = n - 1;
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                count += right - left;
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}
