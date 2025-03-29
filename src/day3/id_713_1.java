package day3;

public class id_713_1 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<= 1) return 0;
        int n = nums.length;
        int v = 1;
        int res = 0;
        int left = 0;
        for(int right = 0; right < n; right++) {
            v *= nums[right];
            while(v > k){
                v /= nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
