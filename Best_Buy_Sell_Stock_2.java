class Solution {
    public int maxProfit(int[] prices) {

     //   int min=prices[0];
        int maxProfit=0;

        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1])
            {
                maxProfit+= prices[i]-prices[i-1];
            }
           // min=Math.min(prices[i],min);
        }
        
        return maxProfit;
    }
}
