// LeetCode 63 - Unique Paths II
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
public class UniquePathsII {
    private Integer[][] memo;
    private int[][] obstacleGrid;
    private int rows;
    private int cols;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        memo = new Integer[rows][cols];
        return dfs(0, 0);
    }

    private int dfs(int row, int col) {
        if (row >= rows || col >= cols || obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (row == rows - 1 && col == cols - 1) {
            return 1;
        }

        if (memo[row][col] == null) {
            memo[row][col] = dfs(row + 1, col) + dfs(row, col + 1);
        }

        return memo[row][col];
    }
}
