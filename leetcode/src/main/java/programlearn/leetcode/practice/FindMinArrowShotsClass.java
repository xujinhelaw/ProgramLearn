/**
 * 452. 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
package programlearn.leetcode.practice;

public class FindMinArrowShotsClass {
    private void sortedArrays(int[][] points) {
        int[][] tmp = new int[1][2];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length - i - 1; j++) {
                if (points[j][0] > points[j + 1][0]) {
                    tmp[0] = points[j];
                    points[j] = points[j + 1];
                    points[j + 1] = tmp[0];
                }
            }
        }
    }

    public int findMinArrowShots(int[][] points) {
        int count = 0;
        if (points.length == 0) {
            return count;
        }
        sortedArrays(points);
        int xstartSource = points[0][0];
        int xendSource = points[0][1];
        int index = 0;
        while (index < points.length) {
            int xstart = points[index][0];
            int xend = points[index][1];
            xstartSource = Math.max(xstart,xstartSource);
            xendSource = Math.min(xend,xendSource);
            if (xstartSource <= xendSource) {
                index++;
            } else {
                count++;
                xstartSource = points[index][0];
                xendSource = points[index][1];

            }
        }
        count++;
        return count;
    }

    public static void main(String[] args) {
        FindMinArrowShotsClass findMinArrowShotsClass = new FindMinArrowShotsClass();
        int[][] points = new int[][] {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShotsClass.findMinArrowShots(points));
    }
}
