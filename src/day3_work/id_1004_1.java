package day3_work;

// https://leetcode.cn/problems/max-consecutive-ones-iii/submissions/622946504/

public class id_1004_1 {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int ans = 0;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                count++;
            }
            while(count > k){
                if(nums[left++] == 0){
                    count--;
                }
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
