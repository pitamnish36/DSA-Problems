class Solution {
    public int maxProfit(int[] prices) {
        int currentMax=0;
        int max=0;
        for(int i=prices.length-1;i>=0;i--){
            if(prices[i]>currentMax)
            currentMax=prices[i];
            else{
                max=Math.max(max,currentMax-prices[i]);
            }
        }
        return max;
    }
}