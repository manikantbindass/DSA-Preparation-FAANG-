# LeetCode 3225 - Maximum Score From Grid Operations
# Time Complexity: O(n^3) | Space Complexity: O(n^3)
from typing import List


class Solution:
    def maximumScore(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if n == 1:
            return 0

        dp = [[[0] * (n + 1) for _ in range(n + 1)] for _ in range(n)]
        prev_max = [[0] * (n + 1) for _ in range(n + 1)]
        prev_suffix_max = [[0] * (n + 1) for _ in range(n + 1)]
        column_prefix_sum = [[0] * (n + 1) for _ in range(n)]

        for col in range(n):
            for row in range(1, n + 1):
                column_prefix_sum[col][row] = column_prefix_sum[col][row - 1] + grid[row - 1][col]

        for col in range(1, n):
            for current_height in range(n + 1):
                for previous_height in range(n + 1):
                    if current_height <= previous_height:
                        extra_score = column_prefix_sum[col][previous_height] - column_prefix_sum[col][current_height]
                        dp[col][current_height][previous_height] = max(
                            dp[col][current_height][previous_height],
                            prev_suffix_max[previous_height][0] + extra_score,
                        )
                    else:
                        extra_score = column_prefix_sum[col - 1][current_height] - column_prefix_sum[col - 1][previous_height]
                        dp[col][current_height][previous_height] = max(
                            dp[col][current_height][previous_height],
                            prev_suffix_max[previous_height][current_height],
                            prev_max[previous_height][current_height] + extra_score,
                        )

            for current_height in range(n + 1):
                prev_max[current_height][0] = dp[col][current_height][0]
                for previous_height in range(1, n + 1):
                    penalty = (
                        column_prefix_sum[col][previous_height] - column_prefix_sum[col][current_height]
                        if previous_height > current_height
                        else 0
                    )
                    prev_max[current_height][previous_height] = max(
                        prev_max[current_height][previous_height - 1],
                        dp[col][current_height][previous_height] - penalty,
                    )

                prev_suffix_max[current_height][n] = dp[col][current_height][n]
                for previous_height in range(n - 1, -1, -1):
                    prev_suffix_max[current_height][previous_height] = max(
                        prev_suffix_max[current_height][previous_height + 1],
                        dp[col][current_height][previous_height],
                    )

        answer = 0
        for height in range(n + 1):
            answer = max(answer, dp[n - 1][n][height], dp[n - 1][0][height])

        return answer
