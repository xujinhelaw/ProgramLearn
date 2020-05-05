/**  求一个序列中不相邻的两个元素的和最大值
 *   讲解博客：https://www.bilibili.com/video/BV12W411v7rd/?spm_id_from=333.788.videocard.0
 **/
package programlearn.leetcode;

public class NotAdjacentElementMaxValue {
    //递归实现
    public int opt(int[] nums) {
        if (nums.length == 0) {
            return  0;
        }
        return opt(nums,nums.length - 1);
    }

    private int opt(int[] nums, int index) {
        if (index == 1) {
            return Math.max(nums[1], nums[0]);
        } else if(index == 0) {
            return nums[0];
        } else {
            return Math.max(opt(nums, index - 2) + nums[index], opt(nums, index -1));
        }
    }

    //动态规划实现
    public int dp_opt(int[] nums){
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        opt[1] = Math.max(nums[1],nums[0]);
        for (int i = 2; i < nums.length; i++) {
            opt[i] = Math.max(opt[i-2] + nums[i], opt[i-1]);
        }
        return opt[nums.length-1];
    }

    public static void main(String[] args) {
        NotAdjacentElementMaxValue notAdjacentElementMaxValue = new NotAdjacentElementMaxValue();
        System.out.println(notAdjacentElementMaxValue.opt(new int[]{1, 2, 4, 1, 7, 8, 3}));
        System.out.println(notAdjacentElementMaxValue.dp_opt(new int[]{1,2}));
    }
}
