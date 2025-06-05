package day16_work;

public class id_70_1 {

    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int i0 = 1;
        int i1 = 1;
        for(int i = 2; i <= n; i++) {
            int new_i = i0 + i1;
            i0 = i1;
            i1 = new_i;
        }
        return i1;
    }

}
