class Solution {
    public int maxProfit(int[] prices) {

        int profit=0;
        int price=99999;
        for(int i =0;i<prices.length;i++)
        {
            
            if(prices[i]<price)
            {
                price=prices[i];

            }
            else
            {
                profit=Math.max(profit,prices[i]-price);
            }
        }
        return profit;
    }
}