class Solution {
    public int maxProfit(int k, int[] prices) {

        int[] cost=new int[k];
        int[] profit=new int[k];

        for(int i=0;i<k;i++)
        {
             cost[i]=Integer.MAX_VALUE;
             profit[i] = 0;
        }

        for(int price: prices )
        {
            for(int i=0;i<k;i++)
            {
                if(i==0)
                {
                    cost[0]=Math.min(cost[0],price);
                    profit[0] = Math.max(profit[0], price - cost[0]);
                }
                else
                {
                    cost[i]=Math.min(cost[i],price- profit[i-1]);
                    profit[i]=Math.max(profit[i],price-cost[i]);
                }
            }
        }

        return profit[k-1];
        
        
    }
}
