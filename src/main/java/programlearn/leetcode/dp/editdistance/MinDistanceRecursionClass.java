/**
 * 最小编辑距离 https://leetcode-cn.com/problems/edit-distance/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * 递推公式
 * dp[i][j]   =   i+j  while (i=0 & j!=0) || (i!=0 & j=0)
 *                dp[i-1][j-1]  while word1[i]=word2[j] && i*j!=0
 *                min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1 while word1[i]!=word2[j] && i*j!=0
 */
package programlearn.leetcode.dp.editdistance;

public class MinDistanceRecursionClass {

    public int recursion(String word1, String word2, int i, int j) {
        if (i * j == 0) {
            return i + j;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return recursion(word1, word2, i - 1, j - 1);
        } else {
            return Math.min(Math.min(recursion(word1, word2, i - 1, j), recursion(word1, word2, i, j - 1)), recursion(word1, word2, i - 1, j - 1)) + 1;
        }
    }

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        String modifyWord1 = " "+ word1;
        String modifyWord2 = " "+ word2;
        return recursion(modifyWord1, modifyWord2, length1, length2);
    }



    public static void main(String[] args) {
        String word1="horse";
        String word2="ros";
        MinDistanceRecursionClass minDistanceRecursionClass = new MinDistanceRecursionClass();
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                result[i][j] = minDistanceRecursionClass.minDistance(word1.substring(0,i),word2.substring(0,j));
            }
        }
        CommonUtils.printTwoDimensionArray(result);
    }
}
