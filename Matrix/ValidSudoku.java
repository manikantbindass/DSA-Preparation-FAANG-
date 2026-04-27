// LeetCode 36 - Valid Sudoku
// Time Complexity: O(1) | Space Complexity: O(1)
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cell = board[row][col];
                if (cell == '.') {
                    continue;
                }

                int digit = cell - '1';
                int box = (row / 3) * 3 + col / 3;
                if (rows[row][digit] || cols[col][digit] || boxes[box][digit]) {
                    return false;
                }

                rows[row][digit] = true;
                cols[col][digit] = true;
                boxes[box][digit] = true;
            }
        }

        return true;
    }
}
