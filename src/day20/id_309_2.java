package day20;

// 冷却期 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

public class id_309_2 {
    public int maxProfit(int[] prices) {
        int f0 = 0;
        int f1 = Integer.MIN_VALUE;
        int ff0 = 0;
        for (int price : prices) {
            int new_ff0 = f0;
            f0 = Math.max(f0, f1 + price);
            f1 = Math.max(f1, ff0 - price);
            ff0 = new_ff0;
        }
        return f0;
    }
}
