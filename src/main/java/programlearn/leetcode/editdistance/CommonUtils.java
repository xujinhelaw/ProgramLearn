package programlearn.leetcode.editdistance;

public class CommonUtils {
    public static void printTwoDimensionArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                if (j == array[i].length - 1) {
                    System.out.print(array[i][j]);
                } else {
                    System.out.print(array[i][j] + ",");
                }
            }
            System.out.println("]");
        }

    }
}
