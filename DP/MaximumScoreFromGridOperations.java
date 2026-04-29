// LeetCode 3225 - Maximum Score From Grid Operations
// Time Complexity: O(n^3) | Space Complexity: O(n^3)
public class MaximumScoreFromGridOperations {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            return 0;
        }

        long[][][] dp = new long[n][n + 1][n + 1];
        long[][] prevMax = new long[n + 1][n + 1];
        long[][] prevSuffixMax = new long[n + 1][n + 1];
        long[][] columnPrefixSum = new long[n][n + 1];

        for (int col = 0; col < n; col++) {
            for (int row = 1; row <= n; row++) {
                columnPrefixSum[col][row] = columnPrefixSum[col][row - 1] + grid[row - 1][col];
            }
        }

        for (int col = 1; col < n; col++) {
            for (int currentHeight = 0; currentHeight <= n; currentHeight++) {
                for (int previousHeight = 0; previousHeight <= n; previousHeight++) {
                    if (currentHeight <= previousHeight) {
                        long extraScore = columnPrefixSum[col][previousHeight] - columnPrefixSum[col][currentHeight];
                        dp[col][currentHeight][previousHeight] = Math.max(
                            dp[col][currentHeight][previousHeight],
                            prevSuffixMax[previousHeight][0] + extraScore
                        );
                    } else {
                        long extraScore = columnPrefixSum[col - 1][currentHeight] - columnPrefixSum[col - 1][previousHeight];
                        dp[col][currentHeight][previousHeight] = Math.max(
                            dp[col][currentHeight][previousHeight],
                            Math.max(
                                prevSuffixMax[previousHeight][currentHeight],
                                prevMax[previousHeight][currentHeight] + extraScore
                            )
                        );
                    }
                }
            }

            for (int currentHeight = 0; currentHeight <= n; currentHeight++) {
                prevMax[currentHeight][0] = dp[col][currentHeight][0];
                for (int previousHeight = 1; previousHeight <= n; previousHeight++) {
                    long penalty = previousHeight > currentHeight
                        ? columnPrefixSum[col][previousHeight] - columnPrefixSum[col][currentHeight]
                        : 0;
                    prevMax[currentHeight][previousHeight] = Math.max(
                        prevMax[currentHeight][previousHeight - 1],
                        dp[col][currentHeight][previousHeight] - penalty
                    );
                }

                prevSuffixMax[currentHeight][n] = dp[col][currentHeight][n];
                for (int previousHeight = n - 1; previousHeight >= 0; previousHeight--) {
                    prevSuffixMax[currentHeight][previousHeight] = Math.max(
                        prevSuffixMax[currentHeight][previousHeight + 1],
                        dp[col][currentHeight][previousHeight]
                    );
                }
            }
        }

        long answer = 0;
        for (int height = 0; height <= n; height++) {
            answer = Math.max(answer, Math.max(dp[n - 1][n][height], dp[n - 1][0][height]));
        }

        return answer;
    }
}
