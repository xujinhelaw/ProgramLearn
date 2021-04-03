package programlearn.leetcode.dynamicprogram.recur2memory2dp;

public class FibonacciMemoryClass {
    private int fibonacii(int n){
        if(n == 1 || n==2 ){
            return 1;
        }
        return fibonacii(n-1) + fibonacii(n-2);
    }
}
