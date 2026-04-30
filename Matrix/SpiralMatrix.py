# LeetCode 54 - Spiral Matrix
# Time Complexity: O(m * n) | Space Complexity: O(m * n)
from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        rows = len(matrix)
        cols = len(matrix[0])
        directions = [0, 1, 0, -1, 0]
        visited = [[False] * cols for _ in range(rows)]
        answer = []

        row = 0
        col = 0
        direction = 0

        for _ in range(rows * cols):
            answer.append(matrix[row][col])
            visited[row][col] = True

            next_row = row + directions[direction]
            next_col = col + directions[direction + 1]
            if next_row < 0 or next_row >= rows or next_col < 0 or next_col >= cols or visited[next_row][next_col]:
                direction = (direction + 1) % 4

            row += directions[direction]
            col += directions[direction + 1]

        return answer
