package programlearn.leetcode.dynamicprogram.profix;

public class MaxProfitOpportunityIClass {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        int k = 0;
        int cost = prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1]){
                k=i;
            }
            dp[i] = Math.max(dp[i-1],dp[i-2]);
        }
        return dp[n];
    }
}
