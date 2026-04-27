// LeetCode 1391 - Check if There is a Valid Path in a Grid
// Time Complexity: O(m * n * alpha(m * n)) | Space Complexity: O(m * n)
public class CheckIfThereIsAValidPathInAGrid {
    private int[] parent;
    private int[][] grid;
    private int rows;
    private int cols;

    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        parent = new int[rows * cols];

        for (int index = 0; index < parent.length; index++) {
            parent[index] = index;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int street = grid[row][col];
                if (street == 1) {
                    connectLeft(row, col);
                    connectRight(row, col);
                } else if (street == 2) {
                    connectUp(row, col);
                    connectDown(row, col);
                } else if (street == 3) {
                    connectLeft(row, col);
                    connectDown(row, col);
                } else if (street == 4) {
                    connectRight(row, col);
                    connectDown(row, col);
                } else if (street == 5) {
                    connectLeft(row, col);
                    connectUp(row, col);
                } else {
                    connectRight(row, col);
                    connectUp(row, col);
                }
            }
        }

        return find(0) == find(rows * cols - 1);
    }

    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private void union(int first, int second) {
        parent[find(first)] = find(second);
    }

    private void connectLeft(int row, int col) {
        if (col > 0 && (grid[row][col - 1] == 1 || grid[row][col - 1] == 4 || grid[row][col - 1] == 6)) {
            union(row * cols + col, row * cols + col - 1);
        }
    }

    private void connectRight(int row, int col) {
        if (col < cols - 1
                && (grid[row][col + 1] == 1 || grid[row][col + 1] == 3 || grid[row][col + 1] == 5)) {
            union(row * cols + col, row * cols + col + 1);
        }
    }

    private void connectUp(int row, int col) {
        if (row > 0 && (grid[row - 1][col] == 2 || grid[row - 1][col] == 3 || grid[row - 1][col] == 4)) {
            union(row * cols + col, (row - 1) * cols + col);
        }
    }

    private void connectDown(int row, int col) {
        if (row < rows - 1
                && (grid[row + 1][col] == 2 || grid[row + 1][col] == 5 || grid[row + 1][col] == 6)) {
            union(row * cols + col, (row + 1) * cols + col);
        }
    }
}
