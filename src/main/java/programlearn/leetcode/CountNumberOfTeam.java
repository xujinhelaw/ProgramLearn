package programlearn.leetcode;

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
