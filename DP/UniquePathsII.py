# LeetCode 63 - Unique Paths II
# Time Complexity: O(m * n) | Space Complexity: O(m * n)
from functools import lru_cache
from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        rows = len(obstacleGrid)
        cols = len(obstacleGrid[0])

        @lru_cache(maxsize=None)
        def dfs(row: int, col: int) -> int:
            if row >= rows or col >= cols or obstacleGrid[row][col] == 1:
                return 0

            if row == rows - 1 and col == cols - 1:
                return 1

            return dfs(row + 1, col) + dfs(row, col + 1)

        return dfs(0, 0)
