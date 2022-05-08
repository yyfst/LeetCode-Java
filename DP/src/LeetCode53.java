public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = dp[i - 1] + nums[i];
            dp[i] = Math.max(tmp, nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }


}
