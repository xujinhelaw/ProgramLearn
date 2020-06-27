package programlearn.leetcode.dfs;

import programlearn.leetcode.common.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxCountGroupClass {

    private Integer count = 0;
    public Map<Integer, List<Integer>> arrayToGraphy(int[][] relation) {
        Map<Integer, List<Integer>> graphy = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            List<Integer> list = graphy.getOrDefault(relation[i][1], new ArrayList<>());
            list.add(relation[i][0]);
            graphy.put(relation[i][1], list);
        }
        return graphy;
    }

    public Integer dfs(Integer root, Map<Integer, List<Integer>> graphy) {
        List<Integer> children = graphy.getOrDefault(root, new ArrayList<>());
        if (children.isEmpty()) {
            return 1;
        }
        int value = 0;
        for (Integer child : children) {
            value = value + dfs(child, graphy);
        }
        value = value + 1;
        if (value % 2 == 0) {
            count++;
        }
        return value;
    }

    public Integer maxCountGroup(int[][] relation) {
        Map<Integer, List<Integer>> graphy = arrayToGraphy(relation);
        List<Integer> children = graphy.getOrDefault(-1, new ArrayList<>());
        if (children.isEmpty()) {
            return 0;
        }
        count=0;
        dfs(children.get(0), graphy);
        return count;
    }

    public static void main(String[] args) {
        MaxCountGroupClass maxCountGroupClass = new MaxCountGroupClass();
        int[][] relation1 = {{2, 1}, {3, 1}, {4, 1}, {5, 2}, {6, 2}, {7, 3}, {8, 3}, {9, 4}, {10, 5}, {11, 5}, {12, 5}, {1, -1}};
        CommonUtils.printTwoDimensionArray(relation1);
        System.out.println(maxCountGroupClass.maxCountGroup(relation1));
        int[][] relation2 = {{2, 1}, {3, 1}, {4, 2}, {5, 2}, {6, 2}, {7, 3}, {8, 3}, {1, -1}};
        CommonUtils.printTwoDimensionArray(relation2);
        System.out.println(maxCountGroupClass.maxCountGroup(relation2));
    }
}
