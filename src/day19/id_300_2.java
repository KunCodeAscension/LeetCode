package day19;

/*
    对递归式子进行一比一翻译即可
 */

public class id_300_2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length,res = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            res = Math.max(res, ++f[i]);
        }
        return res;
    }
}
