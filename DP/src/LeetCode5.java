public class LeetCode5 {
    public class Solution {
        public String longestPalindrome1(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }

            char[] chars = s.toCharArray();
            for (int len = 2; len <= length; len++) {
                for (int leftIndex = 0; leftIndex < length; leftIndex++) {
                    int rightIndex = len + leftIndex - 1;
                    if (rightIndex >= length) {
                        break;
                    }

                    if (chars[leftIndex] == chars[rightIndex]) {
                        if (rightIndex - leftIndex < 3) {
                            dp[leftIndex][rightIndex] = true;
                        } else {
                            dp[leftIndex][rightIndex] = dp[leftIndex + 1][rightIndex - 1];
                        }
                    } else {
                        dp[leftIndex][rightIndex] = false;
                    }

                    if (dp[leftIndex][rightIndex] && ((rightIndex - leftIndex + 1) > maxLen)) {
                        begin = leftIndex;
                        maxLen = rightIndex - leftIndex + 1;
                    }
                }
            }


            return s.substring(begin, maxLen + begin);
        }

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            // dp[i][j] 表示 s[i..j] 是否是回文串
            boolean[][] dp = new boolean[len][len];
            // 初始化：所有长度为 1 的子串都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            char[] charArray = s.toCharArray();
            // 递推开始
            // 先枚举子串长度
            for (int L = 2; L <= len; L++) {
                // 枚举左边界，左边界的上限设置可以宽松一些
                for (int i = 0; i < len; i++) {
                    // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                    int j = L + i - 1;
                    // 如果右边界越界，就可以退出当前循环
                    if (j >= len) {
                        break;
                    }

                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }
    }
}
