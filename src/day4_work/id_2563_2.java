package day4_work;

// 两次相向双指针

import java.util.Arrays;

public class id_2563_2 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums,upper) - count(nums,lower - 1);
    }

    public long count(int[] nums,int upper){
        long res = 0;
        int j = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            while(j > i && nums[j] > upper - nums[i]){
                j--;
            }
            if(j == i) break;
            res += j-i;
        }
        return res;
    }
}
