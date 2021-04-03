/**
 * 数组全排列的实现
 */
package programlearn.leetcode;

import java.util.Arrays;

public class PermutationClass {

    public static void main(String[] args) {
        int[] array={1,2,3,4};
        allSort(array, 0, array.length-1);
    }
    static void allSort(int[] array,int begin,int end){
        if(begin==end){
            System.out.println(Arrays.toString(array));
            return;
        }
        for(int i=begin;i<=end;i++){
            swap(array,begin,i );
            allSort(array, begin+1, end);
            swap(array,begin,i );
        }
    }

    static void swap(int[] array,int a,int b){
        int tem=array[a];
        array[a]=array[b];
        array[b]=tem;
    }

}
