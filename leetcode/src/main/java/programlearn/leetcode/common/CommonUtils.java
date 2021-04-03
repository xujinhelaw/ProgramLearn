package programlearn.leetcode.common;

import java.util.List;

/**
 * 通用的公共方法，目前有的功能包括：打印二维数组、设置二维数组为某值、打印列表
 */
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

    public static void setTwoDimensionArrayInitValue(int[][] arrays,int number){
        for(int i=0;i<arrays.length;i++){
            for(int j=0;j<arrays[i].length;j++){
                arrays[i][j] = number;
            }
        }
    }

    public static <E> void  printArrayList(List<E> arrayList){
        System.out.print("[");
        for(int i=0;i<arrayList.size();i++){
            if(i==arrayList.size()-1){
                System.out.print(arrayList.get(i));
            } else {
                System.out.print(arrayList.get(i)+" ,");
            }
        }
        System.out.print("]");
    }

}
