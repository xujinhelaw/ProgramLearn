package programlearn.leetcode.dynamicprogram.recur2memory2dp;

public class FibonacciRecursiveClass {
    private int count;
    private int fibonacii(int n){
        count++;
        if(n == 1 || n==2 ){
            return 1;
        }
        return fibonacii(n-1) + fibonacii(n-2);
    }

    public static void main(String[] args) {
        FibonacciRecursiveClass fibonacciRecursiveClass = new FibonacciRecursiveClass();
        int N = 10;
        fibonacciRecursiveClass.count = 0;
        System.out.println(fibonacciRecursiveClass.fibonacii(N));
        System.out.println(fibonacciRecursiveClass.count);
    }
}
