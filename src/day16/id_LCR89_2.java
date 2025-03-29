package day16;

import java.util.Arrays;

public class id_LCR89_2 {
    private int[] f;

    public int rob(int[] nums) {
        int n = nums.length;
        f = new int[n + 2];
        Arrays.fill(f, 0);
        for (int i = 0; i < n; i++) {
            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
        }
        return f[n+1];
    }

}
