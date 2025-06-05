package day16;

import java.util.Arrays;

public class id_LCR89_2 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 2];
        Arrays.fill(f, 0);
        for (int i = 0; i < n; i++) {
            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
        }
        return f[n+1];
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            int new_i = Math.max(i1 + nums[i], i2);
            i1 = i2;
            i2 = new_i;
        }
        return i2;
    }

}
