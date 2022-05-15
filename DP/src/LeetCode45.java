import java.util.Arrays;

public class LeetCode45 {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == 0) {
                    if (nums[i] >= j - i) {
                        dp[i][j] = 1;
                    }
                } else {
                   if (nums[i]>=j-i) {

                   }
                }
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len - 1][len - 1];
    }
}
