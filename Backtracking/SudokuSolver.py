# LeetCode 37 - Sudoku Solver
# Time Complexity: O(9^m) | Space Complexity: O(m)
from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        empty_cells = []
        rows = [[False] * 9 for _ in range(9)]
        cols = [[False] * 9 for _ in range(9)]
        boxes = [[[False] * 9 for _ in range(3)] for _ in range(3)]
        solved = False

        for row in range(9):
            for col in range(9):
                if board[row][col] == ".":
                    empty_cells.append((row, col))
                    continue

                digit = ord(board[row][col]) - ord("1")
                rows[row][digit] = True
                cols[col][digit] = True
                boxes[row // 3][col // 3][digit] = True

        def backtrack(index: int) -> None:
            nonlocal solved
            if index == len(empty_cells):
                solved = True
                return

            row, col = empty_cells[index]
            for digit in range(9):
                if rows[row][digit] or cols[col][digit] or boxes[row // 3][col // 3][digit]:
                    continue

                rows[row][digit] = True
                cols[col][digit] = True
                boxes[row // 3][col // 3][digit] = True
                board[row][col] = chr(ord("1") + digit)

                backtrack(index + 1)
                if solved:
                    return

                rows[row][digit] = False
                cols[col][digit] = False
                boxes[row // 3][col // 3][digit] = False
                board[row][col] = "."

        backtrack(0)
