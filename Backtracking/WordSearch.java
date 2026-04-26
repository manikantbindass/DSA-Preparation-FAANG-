// LeetCode 79 - Word Search
// Time Complexity: O(m * n * 3^L) | Space Complexity: O(L)
public class WordSearch {
    private int rows;
    private int cols;
    private String word;
    private char[][] board;
    private final int[] directions = {-1, 0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        this.word = word;
        this.board = board;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, int index) {
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        char saved = board[row][col];
        board[row][col] = '#';

        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + directions[direction];
            int nextCol = col + directions[direction + 1];

            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                continue;
            }

            if (board[nextRow][nextCol] == '#' || !dfs(nextRow, nextCol, index + 1)) {
                continue;
            }

            board[row][col] = saved;
            return true;
        }

        board[row][col] = saved;
        return false;
    }
}
