package programlearn.datastruct.sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionArrayTransfer {
    public static  <T> ArrayList<T> arrayToArrayList(T[] values) {
        return new ArrayList<>(Arrays.asList(values));
    }

    public static void main(String[] args) {
        //将字符串数组转成字符串数组列表
        String[] values = {"Amy", "Bob", "Cary"};
        ArrayList<String> valueList = new ArrayList<String>(Arrays.asList(values));
        ArrayList<String> valueListByGeneric = arrayToArrayList(values);
        System.out.println(valueList);
        System.out.println(valueListByGeneric);
        //将字符串数组列表转成字符串
        String[] newValues = valueList.toArray(new String[0]);
        for (String newValue : newValues)
            System.out.println(newValue);
    }
}
