package A_hot100;

import java.util.Arrays;

/**
 * 动态规划
 * [-2,1,-3,4] 讨论右端点为4的子数组的最大乘积
 *  1，4单独成为一个子数组
 *  2,4和前面的数成为一个子数组，也就是讨论右端点为 -3 的子数组最大乘积后添加4
 *
 * [-2,1,-3,4] 讨论右端点为4的子数组的最大乘积
 *  1，-4单独成为一个子数组
 *  2,-4 和前面的数成为一个子数组，但是 -4 为负数也就是需要讨论以 -3 为右端点的子数组的最小乘积后添加 -4
 *
 * 所以我们要维护两个数组 fMax（右端点为nums[i]的子数组的最大乘积） 和 fMin（右端点为nums[i]的子数组的最小乘积）
 * fMax[i] = Math.max(Math.max(fMax[i - 1] * x, fMin[i - 1] * x), x);
 * fMin[i] = Math.min(Math.min(fMax[i - 1] * x, fMin[i - 1] * x), x);
 * 把这两种都计算一下就无需判断 nums[i]的正负情况了
 *
 * 空间复杂度优化 每次只需要f[i-1] 所以无需数组
 * fMax = Math.max(Math.max(fMax * x, fMin * x), x);
 * fMin = Math.min(Math.min(fMax * x, fMin * x), x);
 */
public class id_152_1 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fMax = new int[n];
        int[] fMin = new int[n];
        fMax[0] = fMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            fMax[i] = Math.max(Math.max(fMax[i - 1] * x, fMin[i - 1] * x), x);
            fMin[i] = Math.min(Math.min(fMax[i - 1] * x, fMin[i - 1] * x), x);
        }
        return Arrays.stream(fMax).max().getAsInt();
    }
}
