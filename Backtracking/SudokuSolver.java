// LeetCode 37 - Sudoku Solver
// Time Complexity: O(9^m) | Space Complexity: O(m)
import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {
    private boolean solved;
    private char[][] board;
    private final List<Integer> emptyCells = new ArrayList<>();
    private final boolean[][] rows = new boolean[9][9];
    private final boolean[][] cols = new boolean[9][9];
    private final boolean[][][] boxes = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        this.board = board;
        solved = false;
        emptyCells.clear();

        for (int row = 0; row < 9; row++) {
            for (int digit = 0; digit < 9; digit++) {
                rows[row][digit] = false;
                cols[row][digit] = false;
                boxes[row / 3][row % 3][digit] = false;
            }
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    emptyCells.add(row * 9 + col);
                    continue;
                }

                int digit = board[row][col] - '1';
                rows[row][digit] = true;
                cols[col][digit] = true;
                boxes[row / 3][col / 3][digit] = true;
            }
        }

        backtrack(0);
    }

    private void backtrack(int index) {
        if (index == emptyCells.size()) {
            solved = true;
            return;
        }

        int position = emptyCells.get(index);
        int row = position / 9;
        int col = position % 9;

        for (int digit = 0; digit < 9; digit++) {
            if (rows[row][digit] || cols[col][digit] || boxes[row / 3][col / 3][digit]) {
                continue;
            }

            rows[row][digit] = true;
            cols[col][digit] = true;
            boxes[row / 3][col / 3][digit] = true;
            board[row][col] = (char) ('1' + digit);

            backtrack(index + 1);
            if (solved) {
                return;
            }

            rows[row][digit] = false;
            cols[col][digit] = false;
            boxes[row / 3][col / 3][digit] = false;
            board[row][col] = '.';
        }
    }
}
