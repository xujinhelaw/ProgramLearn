/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * 输入：[5,4,8,11,null,13,4,7,2,null,null,5,1]
 * 输入：22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 */
package programlearn.leetcode.dfs;

import programlearn.leetcode.bfs.LevelOrderClass;
import programlearn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumClass {
    private List<List<Integer>> resultsList;
    private int count;

    private int dfs(TreeNode root, int sum, List<Integer> results) {
        if (root == null) {
            return 0;
        }
        int leftValue = 0;
        int rightValue = 0;
        count = count + root.val;
        results.add(root.val);
        if (count == sum && root.left == null && root.right == null) {
            List<Integer> copyResults = new ArrayList<>();
            results.forEach(result -> {
                copyResults.add(result);
            });
            resultsList.add(copyResults);
        }
        leftValue = leftValue + dfs(root.left, sum, results);
        if (root.left != null) {
            //不是同一个对象，删除不掉，所以直接使用results.remove(root.left)会出错
            results.remove(results.size() - 1);
        }
        count = count - leftValue;
        rightValue = rightValue + dfs(root.right, sum, results);
        if (root.right != null) {
            results.remove(results.size() - 1);
        }
        count = count - rightValue;
        return root.val;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> results = new ArrayList<>();
        resultsList = new ArrayList<>();
        count = 0;
        dfs(root, sum, results);
        return resultsList;
    }

    public static void main(String[] args) {
        LevelOrderClass levelOrderClass = new LevelOrderClass();
        PathSumClass pathSumClass = new PathSumClass();
        int[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, 5, 1};
        TreeNode root = levelOrderClass.levelOrderConstruct(nums);
    }
}
