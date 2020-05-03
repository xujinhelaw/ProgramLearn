package programlearn.datastruct.sortandsearch;


import java.util.*;

public class ArraysSortTest {
    public static void main(String[] args) {
        //利用库函数实现数组排序,升序和降序
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

        //利用库函数实现数组列表排序,升序和降序
        List<Integer> disorderList = new ArrayList<>(Arrays.asList(3, 21, 4, 9, 10, 7));
        Collections.sort(disorderList);
        System.out.println("print List<Integer> sort!");
        System.out.println(disorderList);
        disorderList.sort(Collections.reverseOrder());
        System.out.println("print List<Integer> sort reverse!");
        System.out.println(disorderList);

    }
}
