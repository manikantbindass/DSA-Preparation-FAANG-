// LeetCode 51 - N-Queens
// Time Complexity: O(n!) | Space Complexity: O(n^2)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    private final List<List<String>> answer = new ArrayList<>();
    private int[] columns;
    private int[] diagonals;
    private int[] antiDiagonals;
    private char[][] board;
    private int size;

    public List<List<String>> solveNQueens(int n) {
        size = n;
        columns = new int[n];
        diagonals = new int[n << 1];
        antiDiagonals = new int[n << 1];
        board = new char[n][n];

        for (int row = 0; row < n; row++) {
            Arrays.fill(board[row], '.');
        }

        backtrack(0);
        return answer;
    }

    private void backtrack(int row) {
        if (row == size) {
            List<String> configuration = new ArrayList<>();
            for (int currentRow = 0; currentRow < size; currentRow++) {
                configuration.add(new String(board[currentRow]));
            }
            answer.add(configuration);
            return;
        }

        for (int col = 0; col < size; col++) {
            int diagonalIndex = row + col;
            int antiDiagonalIndex = size - row + col;

            if (columns[col] + diagonals[diagonalIndex] + antiDiagonals[antiDiagonalIndex] != 0) {
                continue;
            }

            board[row][col] = 'Q';
            columns[col] = 1;
            diagonals[diagonalIndex] = 1;
            antiDiagonals[antiDiagonalIndex] = 1;

            backtrack(row + 1);

            board[row][col] = '.';
            columns[col] = 0;
            diagonals[diagonalIndex] = 0;
            antiDiagonals[antiDiagonalIndex] = 0;
        }
    }
}
