// LeetCode 54 - Spiral Matrix
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] directions = {0, 1, 0, -1, 0};
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> answer = new ArrayList<>();

        int row = 0;
        int col = 0;
        int direction = 0;

        for (int remaining = rows * cols; remaining > 0; remaining--) {
            answer.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + directions[direction];
            int nextCol = col + directions[direction + 1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                direction = (direction + 1) % 4;
            }

            row += directions[direction];
            col += directions[direction + 1];
        }

        return answer;
    }
}
