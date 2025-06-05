package day3_work;

public class review {

    // id_377_1 209
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int s = 0;
        int left = 0;
        int ans = n + 1;
        for (int i = 0; i < n; i++) {
            s += nums[i];
            while(s - nums[left] >= target){
                s -= nums[left];
                left++;
            }
            if(s >= target){
                ans = Math.min(ans,i - left + 1);
            }
        }
        return ans <= n ? ans : 0;
    }

    // 713
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <=0) return 0;
        int n = nums.length;
        int v = 1;
        int ans = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            v *= nums[i];
            while(v >= k){
                v /= nums[left++];
            }
            ans += i - left + 1;
        }
        return ans;
    }

    // 3
    public int lengthOfLongestSubstring(String s) {
        char[] sCharArray = s.toCharArray();
        int[] cnt = new int[128];
        int ans = 0;
        int left = 0;
        for (int i = 0; i < sCharArray.length; i++) {
            cnt[sCharArray[i]]++;
            while(cnt[sCharArray[i]] > 1){
                cnt[sCharArray[left++]]--;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

}
