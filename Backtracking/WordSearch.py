# LeetCode 79 - Word Search
# Time Complexity: O(m * n * 3^L) | Space Complexity: O(L)
from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])
        directions = (-1, 0, 1, 0, -1)

        def dfs(row: int, col: int, index: int) -> bool:
            if board[row][col] != word[index]:
                return False

            if index == len(word) - 1:
                return True

            saved = board[row][col]
            board[row][col] = "#"

            for direction in range(4):
                next_row = row + directions[direction]
                next_col = col + directions[direction + 1]

                if not (0 <= next_row < rows and 0 <= next_col < cols):
                    continue

                if board[next_row][next_col] == "#":
                    continue

                if dfs(next_row, next_col, index + 1):
                    board[row][col] = saved
                    return True

            board[row][col] = saved
            return False

        for row in range(rows):
            for col in range(cols):
                if dfs(row, col, 0):
                    return True

        return False
