# LeetCode 51 - N-Queens
# Time Complexity: O(n!) | Space Complexity: O(n^2)
from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        answer: List[List[str]] = []
        columns = [0] * n
        diagonals = [0] * (n << 1)
        anti_diagonals = [0] * (n << 1)
        board = [["."] * n for _ in range(n)]

        def backtrack(row: int) -> None:
            if row == n:
                answer.append(["".join(current_row) for current_row in board])
                return

            for col in range(n):
                diagonal_index = row + col
                anti_diagonal_index = n - row + col

                if columns[col] + diagonals[diagonal_index] + anti_diagonals[anti_diagonal_index] != 0:
                    continue

                board[row][col] = "Q"
                columns[col] = 1
                diagonals[diagonal_index] = 1
                anti_diagonals[anti_diagonal_index] = 1

                backtrack(row + 1)

                board[row][col] = "."
                columns[col] = 0
                diagonals[diagonal_index] = 0
                anti_diagonals[anti_diagonal_index] = 0

        backtrack(0)
        return answer
