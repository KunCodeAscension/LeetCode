package A_hot100;

/**
 * 摩尔投票法
 * 出现次数大于 n/2 的数的票数一定多余其他数
 * 选择第一个人为候选人，如果后续的人和他数相同则票数+1 不同则票数-1
 * 直到票数为0 选择新的候选人，最后留下来的候选人一定是出现次数大于 n/2 的
 */
public class id_169_1 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int curr = nums[0],count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) curr = nums[i];
            count += nums[i] == curr ? 1 : -1;
        }
        return curr;
    }
}
