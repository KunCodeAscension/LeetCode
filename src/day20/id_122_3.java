package day20;

public class id_122_3 {
    public int maxProfit(int[] prices) {
        int f0 = 0;
        int f1 = Integer.MIN_VALUE;
        for (int price : prices) {
           int new_f0 = Math.max(f0, f1 + price);
           f1 = Math.max(f1, f0 - price);
           f0 = new_f0;
        }
        return f0;
    }
}
