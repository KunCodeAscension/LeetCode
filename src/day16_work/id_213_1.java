package day16_work;

public class id_213_1 {

    public int rob(int[] nums) {
        int f0 = 0,f1 = 0;
        for(int i = 1; i < nums.length; i++){
            int new_f = Math.max(f0 + nums[i],f1);
            f0 = f1;
            f1 = new_f;
        }
        int n0 = 0,n1 = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int new_f = Math.max(n0 + nums[i],n1);
            n0 = n1;
            n1 = new_f;
        }
        return Math.max(n1,f1);
    }

}
