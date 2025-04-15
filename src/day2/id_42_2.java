package day2;

public class id_42_2 {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int left = 0;
        int right = n - 1;
        int pre_max = 0;
        int suf_max = 0;
        // 降低空间复杂度，利用双指针 不断更新前置最大值和后置最大值
        // 如果前置最大值 小于后置最大值 说明当前左指针指向的数前面的桶最大高度就为前置最大值 而 后面的桶的最大高度
        // 最少是当前的后置最大值，所以就可以计算出左指针指向的位置所可以接水的最大容量
        // 右指针同理
        while (left < right) {
            pre_max = Math.max(pre_max, height[left]);
            suf_max = Math.max(suf_max, height[right]);
            if(pre_max < suf_max) {
                ans += pre_max - height[left];
                left++;
            }
            else{
                ans += suf_max - height[right];
                right--;
            }
        }
        return ans;
    }
}
