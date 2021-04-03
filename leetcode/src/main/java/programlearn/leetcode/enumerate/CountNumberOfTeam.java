/**
 * https://leetcode-cn.com/problems/count-number-of-teams/
 * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 *
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分
 *
 * 示例
 * 输入：rating = [1,2,3,4]
 * 输出：4
 */
package programlearn.leetcode.enumerate;

public class CountNumberOfTeam {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }

    public int numTeams2(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int j = 1; j < n - 1; j++) {
            int iless = 0;
            int imore = 0;
            int kless = 0;
            int kmore = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    iless++;
                } else if (rating[i] > rating[j]) {
                    imore++;
                }
            }

            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    kless++;
                } else if (rating[k] > rating[j]) {
                    kmore++;
                }
            }
            count += iless * kmore + imore * kless;
        }

        return count;

    }

    public static void main(String[] args) {
        CountNumberOfTeam countNumberOfTeam = new CountNumberOfTeam();
        int[] rating = {1, 2, 3, 4};
        System.out.println(countNumberOfTeam.numTeams2(rating));
    }
}
