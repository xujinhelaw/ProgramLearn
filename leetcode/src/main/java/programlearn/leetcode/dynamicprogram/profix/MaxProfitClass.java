/**
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 */
package programlearn.leetcode.dynamicprogram.profix;

public class MaxProfitClass {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0){
            return 0;
        }
        int dp[] = new int[n];

        dp[0] = 0;
        int cost = prices[0];

        for (int i = 1; i < n; i++) {
            cost = Math.min(cost, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
        }

        return dp[n - 1];
    }
}
