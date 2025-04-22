package day4_work;

import java.util.Arrays;

public class id_2300_1 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            long target = (success-1) / spells[i];
            if(target < potions[potions.length-1]){
                int start = upperBound(potions,(int) target + 1);
                pairs[i] = potions.length - start;
            }else {
                pairs[i] = 0;
            }
        }
        return pairs;
    }

    public int upperBound(int[] nums,int target){
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }
}
