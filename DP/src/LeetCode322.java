import java.util.Arrays;

public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int coinNum = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j : coins) {
                if (j <= i) {
                    dp[i] = Math.min(dp[i - j] + 1, dp[i]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
