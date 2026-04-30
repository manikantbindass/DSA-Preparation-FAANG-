// LeetCode 3742 - Maximum Path Score in a Grid
// Time Complexity: O(m * n * k) | Space Complexity: O(m * n * k)
public class MaximumPathScoreInAGrid {
    private static final int NEG_INF = -(1 << 30);
    private int[][] grid;
    private Integer[][][] memo;

    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        memo = new Integer[rows][cols][k + 1];

        int answer = dfs(rows - 1, cols - 1, k);
        return answer < 0 ? -1 : answer;
    }

    private int dfs(int row, int col, int remainingCost) {
        if (row < 0 || col < 0 || remainingCost < 0) {
            return NEG_INF;
        }

        if (row == 0 && col == 0) {
            return 0;
        }

        if (memo[row][col][remainingCost] != null) {
            return memo[row][col][remainingCost];
        }

        int score = grid[row][col];
        int nextCost = remainingCost;
        if (grid[row][col] > 0) {
            nextCost--;
        }

        int fromTop = dfs(row - 1, col, nextCost);
        int fromLeft = dfs(row, col - 1, nextCost);
        score += Math.max(fromTop, fromLeft);

        memo[row][col][remainingCost] = score;
        return score;
    }
}
