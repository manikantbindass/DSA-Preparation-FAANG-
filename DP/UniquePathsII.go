// LeetCode 63 - Unique Paths II
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
package main

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	rows := len(obstacleGrid)
	cols := len(obstacleGrid[0])
	memo := make([][]int, rows)

	for row := 0; row < rows; row++ {
		memo[row] = make([]int, cols)
		for col := 0; col < cols; col++ {
			memo[row][col] = -1
		}
	}

	var dfs func(int, int) int
	dfs = func(row int, col int) int {
		if row >= rows || col >= cols || obstacleGrid[row][col] == 1 {
			return 0
		}

		if row == rows-1 && col == cols-1 {
			return 1
		}

		if memo[row][col] != -1 {
			return memo[row][col]
		}

		memo[row][col] = dfs(row+1, col) + dfs(row, col+1)
		return memo[row][col]
	}

	return dfs(0, 0)
}
