package A_hot100;

import java.util.Arrays;

public class id_287_1 {

    // n + 1 个数的数组 数组内数的范围 [1,n] 求重复数
    // 2a + 2b = a + b + kc
    // a + b = kc
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre = 0;
        while(slow != pre){
            pre = nums[pre];
            slow = nums[slow];
        }
        return slow;
    }
}
