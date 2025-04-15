package day2;

// https://leetcode.cn/problems/trapping-rain-water/

import java.util.Arrays;

public class id_42_1 {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int[] pre_max = new int[n];
        Arrays.fill(pre_max, 0);
        // 双重循环 第一个循环算出前置最大值
        pre_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            pre_max[i] = Math.max(pre_max[i - 1], height[i]);
        }
        // 第二个循环算出后置最大值
        int[] suf_max = new int[n];
        Arrays.fill(suf_max, 0);
        suf_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf_max[i] = Math.max(suf_max[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(pre_max[i], suf_max[i]) - height[i];
        }
        return ans;
    }
}
