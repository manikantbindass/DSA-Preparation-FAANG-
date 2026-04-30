# LeetCode 3742 - Maximum Path Score in a Grid
# Time Complexity: O(m * n * k) | Space Complexity: O(m * n * k)
from functools import lru_cache
from typing import List


class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        rows = len(grid)
        cols = len(grid[0])
        negative_infinity = -(1 << 30)

        @lru_cache(maxsize=None)
        def dfs(row: int, col: int, remaining_cost: int) -> int:
            if row < 0 or col < 0 or remaining_cost < 0:
                return negative_infinity

            if row == 0 and col == 0:
                return 0

            score = grid[row][col]
            next_cost = remaining_cost - (1 if grid[row][col] > 0 else 0)
            score += max(
                dfs(row - 1, col, next_cost),
                dfs(row, col - 1, next_cost),
            )
            return score

        answer = dfs(rows - 1, cols - 1, k)
        return -1 if answer < 0 else answer
