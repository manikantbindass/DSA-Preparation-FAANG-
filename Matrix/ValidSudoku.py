# LeetCode 36 - Valid Sudoku
# Time Complexity: O(1) | Space Complexity: O(1)
from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [[False] * 9 for _ in range(9)]
        cols = [[False] * 9 for _ in range(9)]
        boxes = [[False] * 9 for _ in range(9)]

        for row in range(9):
            for col in range(9):
                cell = board[row][col]
                if cell == ".":
                    continue

                digit = ord(cell) - ord("1")
                box = (row // 3) * 3 + col // 3
                if rows[row][digit] or cols[col][digit] or boxes[box][digit]:
                    return False

                rows[row][digit] = True
                cols[col][digit] = True
                boxes[box][digit] = True

        return True
