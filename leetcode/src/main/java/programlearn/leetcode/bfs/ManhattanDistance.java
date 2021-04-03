/** 曼哈顿距离总和最小的车站
 *  二维数组 grid 为街道区域地图
 *  数组中数值的含义如下：1表示商店，2表示学校，3表示医院，4表示超市，0表示空地
 *  现从城市的空地挑选一处作为公交车站，要求满足公交车站到4种建筑的曼哈顿距离和最小，请返回选址地址（如有多解，只返回x,y最小的值）
 *  两点间的曼哈顿距离 = |x1-x2|+|y1-y2|
 *  示例 {{1, 2, 3, 4}, {0, 1, 1, 0}, {4, 0, 2, 0}, {0, 3, 0, 0}}
 *  返回值[2,1]
 */
package programlearn.leetcode.bfs;

import java.util.*;

public class ManhattanDistance {
    private class Location {
        private int x;
        private int y;

        private Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private enum buildingType {
        STORE(1), SCHOOL(2), HOSPITAL(3), DELAY(4);
        private int value;

        private buildingType(int value) {
            this.value = value;
        }
    }

    private void isValidate(int[][] grid, Queue<Location> queue, Set<Location> seenSet, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length) {
            Location location = new Location(i, j);
            if (!seenSet.contains(location)) {
                queue.add(location);
                seenSet.add(location);
            }
        }
    }

    private int bfs(int[][] grid, int startI, int startJ, int target) {
        Queue<Location> queue = new LinkedList<>();
        Set<Location> seenSet = new HashSet<>();
        queue.add(new Location(startI, startJ));
        int i = startI;
        int j = startJ;

        while (!queue.isEmpty()) {
            seenSet.add(new Location(i, j));
            Location location = queue.poll();
            if (grid[location.x][location.y] == target) {
                return Math.abs(location.x - startI) + Math.abs(location.y - startJ);
            }
            i = location.x;
            j = location.y;
            isValidate(grid, queue, seenSet, i + 1, j);
            isValidate(grid, queue, seenSet, i, j + 1);
            isValidate(grid, queue, seenSet, i - 1, j);
            isValidate(grid, queue, seenSet, i, j - 1);

        }
        return Integer.MAX_VALUE;
    }

    private int[][] manhattanDistanceLocation(int[][] grid) {
        int[][] location = {{0, 0}};
        int minManhattanDistance = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < grid[0].length; j++) {
            for (i = 0; i < grid.length; i++) {
                if (grid[i][j] == 0) {
                    int manhattanDistance = bfs(grid, i, j, buildingType.STORE.value) + bfs(grid, i, j, buildingType.SCHOOL.value) + bfs(grid, i, j, buildingType.HOSPITAL.value) + bfs(grid, i, j, buildingType.DELAY.value);
                    if (manhattanDistance < minManhattanDistance) {
                        location[0][0] = i;
                        location[0][1] = j;
                        minManhattanDistance = manhattanDistance;
                    }
                }
            }
        }
        return location;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 2, 3, 4}, {0, 1, 1, 0}, {4, 0, 2, 0}, {0, 3, 0, 0}};
        ManhattanDistance manhattanDistance = new ManhattanDistance();
        int[][] res1 = manhattanDistance.manhattanDistanceLocation(grid1);
        System.out.println("x:" + res1[0][0] + " y:" + res1[0][1]);

        int[][] grid2 = {{0, 1, 1, 2, 0, 0}, {0, 0, 0, 1, 2, 0}, {1, 2, 0, 3, 0, 4}, {0, 0, 4, 1, 1, 0}};
        int[][] res2 = manhattanDistance.manhattanDistanceLocation(grid2);
        System.out.println("x:" + res2[0][0] + " y:" + res2[0][1]);
    }
}
