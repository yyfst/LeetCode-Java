import java.util.Arrays;

public class LeetCode55 {
    public boolean canJump2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }

        if (nums[0] == 0) {
            return false;
        }

        boolean res = false;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i] && (i + j < len); j++) {
                dp[i + j] = dp[i + j - 1];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[len - 1];
    }


    public boolean canJump1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }

        if (nums[0] == 0) {
            return false;
        }

        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i] && (i + j < len); j++) {
                dp[i + j] = dp[i + j - 1];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[len - 1];
    }

    // 超时超时超时
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }

        boolean[][] dp = new boolean[len][len];
        dp[0][0] = true;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == 0) {
                    dp[i][j] = nums[i] >= j - i;
                } else {
                    int dis = j - i;
                    dp[i][j] = dp[i - 1][j] || (dp[i][j - 1] && nums[i] >= dis);
                }
            }
        }

        return dp[len - 1][len - 1];
    }

}
