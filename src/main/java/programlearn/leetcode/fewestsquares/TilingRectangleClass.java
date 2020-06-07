/**
 * 铺瓷砖问题
 * https://leetcode-cn.com/problems/tiling-a-rectangle-with-the-fewest-squares/submissions/
 *
 * 解题思路：https://leetcode-cn.com/problems/tiling-a-rectangle-with-the-fewest-squares/solution/5241-pu-ci-zhuan-dong-tai-gui-hua-by-xu-yuan-shu/
 *
 */
package programlearn.leetcode.fewestsquares;

public class TilingRectangleClass {

    private void setTwoDimensionArrayInitValue(int[][] arrays, int number) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                arrays[i][j] = number;
            }
        }
    }

    private void minSquareCount(int i, int j, int minIj, int[][] dp) {
        for (int k = 1; k <= minIj; k++) {
            int i2 = i - k;
            int j1 = j - k;
            for (int i1 = 0; i1 <= i2; i1++) {
                for (int j2 = j1; j2 <= j; j2++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i1][j2] + dp[i2][j - j2] + dp[i - i1][j1] + dp[i2 - i1][j2 - j1] + 1);
                }
            }
        }
    }

    public int tilingRectangle(int n, int m) {
        int max = Math.max(n, m);
        int[][] dp = new int[max + 1][max + 1];
        setTwoDimensionArrayInitValue(dp, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    minSquareCount(i, j, Math.min(i, j), dp);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int n = 11;
        int m = 13;
        TilingRectangleClass tilingRectangleClass = new TilingRectangleClass();
        System.out.println(tilingRectangleClass.tilingRectangle(n, m));
    }
}
