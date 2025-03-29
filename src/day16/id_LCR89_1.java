package day16;

import java.util.Arrays;

public class id_LCR89_1 {
    private int[] nums;
    private int[] CACHE;

    public int rob(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        CACHE = new int[n];
        Arrays.fill(CACHE, -1);
        return f(n-1);
    }

    public int f(int i){
        if(i < 0) return 0;
        if(CACHE[i] != -1) return CACHE[i];
        int res = Math.max(f(i-1), f(i-2) + nums[i]);
        CACHE[i] = res;
        return res;
    }
}
