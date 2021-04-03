/** 讲堆的博客：https://www.jianshu.com/p/6b526aa481b1**/
package programlearn.datastruct.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapTest {
    private PriorityQueue<Integer> priorityQueue;

    //默认比较器的堆排序和堆操作
    public void normalHeapTest() {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        heap.offer(7);
        heap.offer(3);
        heap.offer(6);
        heap.offer(2);
        heap.offer(1);
        heap.offer(4);
        heap.offer(5);
        System.out.println(heap);
        System.out.println(heap.peek());
        System.out.println(heap);
        System.out.println(heap.remove());
        System.out.println(heap);
    }

    //自定义比较器的堆排序和堆操作
    public void heapTestWithComparator() {
        PriorityQueue<Employee> heap = new PriorityQueue<Employee>(new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getCode() - o2.getCode();
            }
        });
        heap.add(new Employee(7,"amy"));
        heap.add(new Employee(3,"bob"));
        heap.add(new Employee(6,"cary"));
        heap.add(new Employee(2,"david"));
        heap.add(new Employee(1,"eli"));
        heap.add(new Employee(4,"lily"));
        heap.add(new Employee(5,"monkey"));
        System.out.println(heap);
    }

    public static void main(String[] args) {
        HeapTest heapTest = new HeapTest();
        heapTest.normalHeapTest();
        heapTest.heapTestWithComparator();
    }
}
