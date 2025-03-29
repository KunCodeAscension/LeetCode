package day16;

public class id_LCR89_3 {
    public int rob(int[] nums) {
        int f0 = 0;int f1 = 0;
        for (int num : nums) {
            int new_F = Math.max(f1, f0 + num);
            f0 = f1;
            f1 = new_F;
        }
        return f1;
    }
}
