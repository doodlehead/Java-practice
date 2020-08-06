public class BestTimeToBuyAndSellStock {
    //Runtime: 2 ms
    //Memory usage: 41.8 MB
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int runningMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < runningMin) runningMin = prices[i];

            max = Math.max(max, prices[i] - runningMin);
        }
        return max;
    }
}
