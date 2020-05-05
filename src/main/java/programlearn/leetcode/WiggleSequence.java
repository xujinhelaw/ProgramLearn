/***摆动序列 https://leetcode-cn.com/problems/wiggle-subsequence/
 * 讲得最好的博客：https://blog.csdn.net/kexinxin1/article/details/93015779
 * ***/
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

    public int wiggleMaxLength1(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
    }

    public void solution1(int[] nums) {
        wiggleMaxLength1(nums);
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int ans = nums.length;
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                ans--;
            else if (nums[i] > nums[i - 1]) {
                if (flag == 1) {
                    ans--;
                } else {
                    flag = 1;
                }
            } else {
                if (flag == -1) {
                    ans--;
                } else {
                    flag = -1;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        WiggleSequence wiggleSequence = new WiggleSequence();
        int[] datas = new int[]{1, 7, 4, 9, 2, 5};
        System.out.println(wiggleSequence.wiggleMaxLength(datas));
    }
}
