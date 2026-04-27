# LeetCode 1391 - Check if There is a Valid Path in a Grid
# Time Complexity: O(m * n * alpha(m * n)) | Space Complexity: O(m * n)
from typing import List


class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        rows = len(grid)
        cols = len(grid[0])
        parent = list(range(rows * cols))

        def find(node: int) -> int:
            if parent[node] != node:
                parent[node] = find(parent[node])
            return parent[node]

        def union(first: int, second: int) -> None:
            parent[find(first)] = find(second)

        def connect_left(row: int, col: int) -> None:
            if col > 0 and grid[row][col - 1] in (1, 4, 6):
                union(row * cols + col, row * cols + col - 1)

        def connect_right(row: int, col: int) -> None:
            if col < cols - 1 and grid[row][col + 1] in (1, 3, 5):
                union(row * cols + col, row * cols + col + 1)

        def connect_up(row: int, col: int) -> None:
            if row > 0 and grid[row - 1][col] in (2, 3, 4):
                union(row * cols + col, (row - 1) * cols + col)

        def connect_down(row: int, col: int) -> None:
            if row < rows - 1 and grid[row + 1][col] in (2, 5, 6):
                union(row * cols + col, (row + 1) * cols + col)

        for row in range(rows):
            for col in range(cols):
                street = grid[row][col]
                if street == 1:
                    connect_left(row, col)
                    connect_right(row, col)
                elif street == 2:
                    connect_up(row, col)
                    connect_down(row, col)
                elif street == 3:
                    connect_left(row, col)
                    connect_down(row, col)
                elif street == 4:
                    connect_right(row, col)
                    connect_down(row, col)
                elif street == 5:
                    connect_left(row, col)
                    connect_up(row, col)
                else:
                    connect_right(row, col)
                    connect_up(row, col)

        return find(0) == find(rows * cols - 1)
