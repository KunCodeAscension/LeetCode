package day16_work;

public class id_746_1 {

    public int minCostClimbingStairs(int[] cost) {
        int f0 = 0,f1 = 0;
        for(int i = 1 ; i < cost.length ; i++){
            int new_f = Math.min(cost[i-1] + f0, cost[i] + f1);
            f0 = f1;
            f1 = new_f;
        }
        return f1;
    }

}
