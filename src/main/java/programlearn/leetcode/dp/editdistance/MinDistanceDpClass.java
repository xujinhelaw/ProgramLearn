/**
 * 最小编辑距离 https://leetcode-cn.com/problems/edit-distance/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * 动态规划解题
 * 递推公式
 * dp[i][j]   =   i+j  while (i=0 & j!=0) || (i!=0 & j=0)
 *                dp[i-1][j-1]  while word1[i]=word2[j] && i*j!=0
 *                min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1 while word1[i]!=word2[j] && i*j!=0
 */
package programlearn.leetcode.dp.editdistance;

public class MinDistanceDpClass {

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i * j == 0) {
                    dp[i][j] = i + j;
                    continue;
                }
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String word1="horse";
        String word2="ros";
        MinDistanceDpClass minDistanceRecursionClass = new MinDistanceDpClass();
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                result[i][j] = minDistanceRecursionClass.minDistance(word1.substring(0,i),word2.substring(0,j));
            }
        }
        CommonUtils.printTwoDimensionArray(result);
    }
}
