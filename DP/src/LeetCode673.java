import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 最长递增子序列的个数
 */
public class LeetCode673 {
    public int findNumberOfLIS1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int maxLen = 0;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }

                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(cnt));

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxLen) {
                res += cnt[i];
            }
        }

        System.out.println(maxLen);
        System.out.println(res);
        return res;
    }

    // 原创垃圾代码，不知道哪里有问题
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }

        int maxLen = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = dp[i + 1][j - 1];
                if (nums[j] > nums[j - 1]) {
                    dp[i][j]++;
                }

                if (nums[i] < nums[i + 1]) {
                    dp[i][j]++;
                }

                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(maxLen);
        return maxLen;
    }


    public int findNumberOfLIS2(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLength = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                res += count[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
        System.out.println(res);
        System.out.println(maxLength);
        return res;
    }
}


