package A_hot100;

public class id_283_1 {

    // 移动前 [0,1,0,3,12]
    // 移动后 [1,3,12,0,0]

    /**
     * 暴力解法
     */
    public void moveZeroes1(int[] nums) {
        int i = 0;
        int num = 0;
        while (num < nums.length) {
            if(nums[i] != 0){
                i++;
                num++;
            }else {
                for(int j = i + 1; j < nums.length; j++){
                    nums[j - 1] = nums[j];
                }
                nums[nums.length - 1] = 0;
                num++;
            }
        }
    }

    /**
     * 双指针 i第一次遍历数组 找到不为 0 的数移动到最前面
     * 第二次遍历从 j 开始后续的全为0
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for(int i = j; i < nums.length; i++){
            nums[i] = 0;
        }
    }

}
