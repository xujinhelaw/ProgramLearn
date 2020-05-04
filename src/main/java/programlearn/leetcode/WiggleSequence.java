/***摆动序列 https://leetcode-cn.com/problems/wiggle-subsequence/ ***/
package programlearn.leetcode;

public class WiggleSequence {

    private int calculate(int[] nums, int index, boolean isUp) {
        int maxcount = 0;
        for (int i = index + 1; i < nums.length; i++) {
            if ((isUp && nums[i] > nums[index]) || (!isUp && nums[i] < nums[index]))
                maxcount = Math.max(maxcount, 1 + calculate(nums, i, !isUp));
        }
        return maxcount;
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
    }

    public static void main(String[] args) {
        WiggleSequence wiggleSequence = new WiggleSequence();
        int[] datas = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleSequence.wiggleMaxLength(datas));
    }
}
