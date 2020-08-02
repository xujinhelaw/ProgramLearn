package programlearn.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShotsOptimizeClass {
    public int findMinArrowShots(int[][] points){
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int res = 1;
        int xEndSource = points[0][1];
        for(int[] point:points){
            int xStart = point[0];
            int xEnd = point[1];
            if(xStart > xEndSource){
                res++;
                xEndSource = xEnd;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        FindMinArrowShotsOptimizeClass findMinArrowShotsOptimizeClass = new FindMinArrowShotsOptimizeClass();
        int[][] points = new int[][] {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShotsOptimizeClass.findMinArrowShots(points));
    }
}
