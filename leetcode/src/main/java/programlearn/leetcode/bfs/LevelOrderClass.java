/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 广度优先搜索
 */
package programlearn.leetcode.bfs;

import programlearn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderClass {

    public TreeNode levelOrderConstruct(int[] nums) {
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueTmp = new LinkedList<>();
        TreeNode root = null;
        if (nums.length > 0) {
            root = new TreeNode(nums[0]);
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                index = index + 1;
                if (index < nums.length) {
                    TreeNode nodeLeft = new TreeNode(nums[index]);
                    node.left = nodeLeft;
                    queueTmp.offer(nodeLeft);
                }
                index = index + 1;
                if (index < nums.length) {
                    TreeNode nodeRight = new TreeNode(nums[index]);
                    node.right = nodeRight;
                    queueTmp.offer(nodeRight);
                }
            }
            queue = queueTmp;
        }
        return root;
    }

    public TreeNode levelOrderConstruct(String[] nums) {
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueTmp = new LinkedList<>();
        TreeNode root = null;
        if (nums.length > 0) {
            root = new TreeNode(Integer.parseInt(nums[0]));
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                index = index + 1;
                if (index < nums.length && !"null".equals(nums[index])) {
                    TreeNode nodeLeft = new TreeNode(Integer.parseInt(nums[index]));
                    node.left = nodeLeft;
                    queueTmp.offer(nodeLeft);
                }
                index = index + 1;
                if (index < nums.length && !"null".equals(nums[index])) {
                    TreeNode nodeRight = new TreeNode(Integer.parseInt(nums[index]));
                    node.right = nodeRight;
                    queueTmp.offer(nodeRight);
                }
            }
            queue = queueTmp;
        }
        return root;
    }

    public TreeNode levelOrderConstruct(String numString) {
        int startIndex = numString.indexOf("[");
        int endIndex = numString.indexOf("]");
        if (startIndex != -1) {
            numString = numString.substring(startIndex + 1);
        }
        if (endIndex != -1) {
            numString = numString.substring(0, endIndex - 1);
        }
        String[] nums = numString.split(",");
        return levelOrderConstruct(nums);
    }

    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        //只有当节点不为空的时候，才能队，避免出现空指针问题
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Queue<TreeNode> queueTmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                arrayList.add(node.val);
                if (node.left != null) {
                    queueTmp.offer(node.left);
                }
                if (node.right != null) {
                    queueTmp.offer(node.right);
                }
            }
            queue = queueTmp;
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

    public List<List<Integer>> levelOrderLn(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> arrayLists = new ArrayList<>();
        //只有当节点不为空的时候，才能队，避免出现空指针问题
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> arrayList = new ArrayList<>();
            //这个临时的队列，放在这里很重要
            Queue<TreeNode> queueTmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                arrayList.add(node.val);
                if (node.left != null) {
                    queueTmp.offer(node.left);
                }
                if (node.right != null) {
                    queueTmp.offer(node.right);
                }
            }
            arrayLists.add(arrayList);
            queue = queueTmp;
        }
        return arrayLists;
    }

}
