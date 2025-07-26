package A_hot100;

public class id_121_1 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

}
