package A_hot100;

public class id_136_1 {
    /**
     * 位运算
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
