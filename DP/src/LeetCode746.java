public class LeetCode746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return Math.min(dp[n - 1] + cost[n - 1], dp[n - 2]);
    }
}
