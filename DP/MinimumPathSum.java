// LeetCode 64 - Minimum Path Sum
// Time Complexity: O(mn) | Space Complexity: O(1)
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }

                int fromTop = row > 0 ? grid[row - 1][col] : Integer.MAX_VALUE;
                int fromLeft = col > 0 ? grid[row][col - 1] : Integer.MAX_VALUE;
                grid[row][col] += Math.min(fromTop, fromLeft);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
