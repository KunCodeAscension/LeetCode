package A_hot100;

/**
 * 前后缀计算
 */
public class id_238_1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        int[] ans = new int[n];
        ans[n - 1] = left[n - 1] * right[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
