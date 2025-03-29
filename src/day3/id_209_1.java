package day3;

public class id_209_1 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int left = 0;
        int s = 0;
        for (int right = 0; right < n; right++) {
            s += nums[right];
            while (s - nums[left] >= target) {
                s -= nums[left];
                left += 1;
            }
            if(s >= target){
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans <= n ? ans : 0;
    }
}
