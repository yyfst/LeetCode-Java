public class LeetCode213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(getMaxResult(0, n - 2, nums), getMaxResult(1, n - 1, nums));
    }

    private int getMaxResult(int i, int j, int[] nums) {
        int n = j - i + 1;
        int[] dp = new int[n];
        dp[0] = nums[i];
        dp[1] = Math.max(nums[i], nums[i + 1]);

        for (int index = i + 2; index <= j; index++) {
            dp[index - i] = Math.max(dp[index - i - 1], dp[index - i - 2] + nums[index]);
        }
        return dp[n - 1];
    }
}
