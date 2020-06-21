package programlearn.leetcode.dfs;

import programlearn.leetcode.common.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxCountGroupClass {

    public class Result {
        Integer groupcount;
        Integer employeeCount;
        boolean divideGroupSuccess;
        public Result(Integer groupcount,Integer employeeCount,boolean divideGroupSuccess){
            this.groupcount = groupcount;
            this.employeeCount = employeeCount;
            this.divideGroupSuccess = divideGroupSuccess;
        }
    }

    public Map<Integer, List<Integer>> arrayToGraphy(int[][] relation) {
        Map<Integer, List<Integer>> graphy = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            List<Integer> list = graphy.getOrDefault(relation[i][1], new ArrayList<>());
            list.add(relation[i][0]);
            graphy.put(relation[i][1], list);
        }
        return graphy;
    }

    public Result dfs(Integer root, Map<Integer, List<Integer>> graphy, Result result) {
        if(graphy.get(root)==null){
            return result;
        }
        List<Integer> children = graphy.get(root);
        for(Integer child : children){
            result = dfs(child,graphy,result);
            if(result.divideGroupSuccess){
                result.divideGroupSuccess = false;
            } else {
                result.employeeCount++;
            }
        }
        result.employeeCount++;
        if((result.employeeCount)%2 == 0){
            result.groupcount++;
            result.employeeCount=0;
            result.divideGroupSuccess = true;
        } else {
            result.employeeCount--;
        }
        return result;
    }

    public Integer maxCountGroup(int[][] relation) {
        Map<Integer, List<Integer>> graphy = arrayToGraphy(relation);
        Integer root = graphy.get(-1).get(0);
        Result result = dfs(root,graphy,new Result(0,0,false));
        return result.groupcount;
    }

    public static void main(String[] args) {
        MaxCountGroupClass maxCountGroupClass = new MaxCountGroupClass();
        int[][] relation1 = {{2, 1}, {3, 1}, {4, 1}, {5, 2}, {6, 2}, {7, 3}, {8, 3}, {9, 4}, {10, 5}, {11, 5}, {12, 5}, {1, -1}};
        CommonUtils.printTwoDimensionArray(relation1);
        System.out.println(maxCountGroupClass.maxCountGroup(relation1));
    }
}
