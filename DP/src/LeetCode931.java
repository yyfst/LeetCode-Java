public class LeetCode931 {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    dp[0][j] = matrix[0][j];
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][j];
                }
                if (j > 0 && j + 1 < col) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]),
                            dp[i - 1][j + 1]) + matrix[i][j];
                }
                if (j == col - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + matrix[i][j];
                }
            }
        }

        int min = dp[row - 1][0];
        for (int j = 1; j < col; j++) {
            min = Math.min(min, dp[row - 1][j]);
        }
        return min;
    }
}
