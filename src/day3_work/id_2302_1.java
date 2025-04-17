package day3_work;

// https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/

public class id_2302_1 {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int left = 0;
        long count = 0;
        long length = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];length ++;
            while (count * length >= k) {
                length --;
                count -= nums[left];
                left++;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
