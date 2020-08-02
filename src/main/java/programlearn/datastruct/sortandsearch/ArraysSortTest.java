package programlearn.datastruct.sortandsearch;


import programlearn.leetcode.common.CommonUtils;

import java.util.*;

public class ArraysSortTest {
    public static void main(String[] args) {
        //利用库函数实现int一维数组排序，升序和降序
        int[] disordersIntType = new int[]{3, 21, 4, 9, 10, 7};
        Arrays.sort(disordersIntType);
        System.out.println("print Int sort!");
        for (Integer disorderIntType : disordersIntType) {
            System.out.println(disorderIntType);
        }
        for (int i = 0; i < disordersIntType.length / 2; i++) {
            int tmp = disordersIntType[disordersIntType.length - 1 - i];
            disordersIntType[disordersIntType.length - 1 - i] = disordersIntType[i];
            disordersIntType[i] = tmp;
        }
        System.out.println("print Int sort reverse!");
        for (Integer disorderIntType : disordersIntType) {
            System.out.println(disorderIntType);
        }

        //利用库函数实现int二维数组排序，升序(降序只要修改一下 o1 和 o2的位置)
        int[][] disorderPoints = new int[][]{{4, 1}, {4, 3}, {3, 1}, {3, 2}, {5, 2}};
        Arrays.sort(disorderPoints, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        System.out.println("print int[][] sort!");
        CommonUtils.printTwoDimensionArray(disorderPoints);

        //利用库函数实现Integer一维数组排序,升序和降序
        Integer[] disorders = {3, 21, 4, 9, 10, 7};
        Arrays.sort(disorders);
        System.out.println("print Integer sort!");
        for (Integer disorder : disorders) {
            System.out.println(disorder);
        }
        Arrays.sort(disorders, Comparator.reverseOrder());
        System.out.println("print Integer sort reverse!");
        for (Integer disorder : disorders) {
            System.out.println(disorder);
        }

        //利用库函数实现Integer一维数组列表排序,升序和降序
        List<Integer> disorderList = new ArrayList<>(Arrays.asList(3, 21, 4, 9, 10, 7));
        Collections.sort(disorderList);
        System.out.println("print List<Integer> sort!");
        System.out.println(disorderList);
        disorderList.sort(Collections.reverseOrder());
        System.out.println("print List<Integer> sort reverse!");
        System.out.println(disorderList);

    }
}
