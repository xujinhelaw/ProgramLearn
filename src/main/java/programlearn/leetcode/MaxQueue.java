/**
 *请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
package programlearn.leetcode;

import java.util.*;

public class MaxQueue {
    private Deque<Integer> maxQue;
    private Queue<Integer> queue;

    public MaxQueue() {
        maxQue = new ArrayDeque<>();
        queue = new LinkedList<>();
        maxQue.addLast(Integer.MIN_VALUE);
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return maxQue.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while(!maxQue.isEmpty() && maxQue.peekLast() < value) {
            maxQue.removeLast();
        }
        maxQue.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        //注意这里容易犯严重错误，对于封装类型的等于，不能使用 ==，而必须使用equals
        if(queue.peek().equals(maxQue.peekFirst()))
            maxQue.removeFirst();
        return queue.remove();
    }

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        obj.push_back(1);
        obj.push_back(2);
        int param_1 = obj.max_value();
        int param_2 = obj.pop_front();
        int param_3 = obj.max_value();
        System.out.println(param_1 + "," + param_2 + "," + param_3);

        //下面只是一个补充知识点，跟题目本身无关
        // 注意这里容易犯严重错误，对于封装类型的等于，不能使用 ==，而必须使用equals
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        LinkedList<Integer> linkedList = new LinkedList<>();
        Integer a = new Integer(2);
        linkedList.add(a);
        if (arrayList.get(0) == linkedList.get(0)) {
            System.out.println("true"); //此处不会返回true
        }
    }
}
