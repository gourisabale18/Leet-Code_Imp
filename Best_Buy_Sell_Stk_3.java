class Solution {
    public int maxProfit(int[] prices) {

        int cost1=Integer.MAX_VALUE;
        int cost2=Integer.MAX_VALUE;

        int profit1=0;
        int profit2=0;

        for(int i=0;i<prices.length;i++)
        {
            cost1=Math.min(cost1, prices[i]);
            profit1=Math.max(profit1,prices[i]-cost1);
            cost2=Math.min(cost2, prices[i]-profit1);
            profit2=Math.max(profit2,prices[i]-cost2);
        }

        return profit2;
        
    }
}
