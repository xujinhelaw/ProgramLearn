/**设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 *
 **/
package programlearn.leetcode.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KCountMin {
    public int[] smallestK(int[] arr, int k) {
        if (arr == null)
            return null;
        int[] result = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int element : arr) {
            heap.add(element);
        }
        for (int i = 0; i < k; i++) {
            result[i] = heap.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        KCountMin kCountMin = new KCountMin();
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        int[] result = kCountMin.smallestK(arr, k);
        List<Integer> resultList =  Arrays.stream(result).boxed().collect(Collectors.toList());
        System.out.println(resultList);
    }
}
