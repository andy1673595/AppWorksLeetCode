package java.array;
import java.util.Arrays;

public class BestTimeBuyStock121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int tmpProfit = prices[i] - min;
            if (profit < tmpProfit) {
                profit = tmpProfit;
            }
        }
        return profit;
    }

}
