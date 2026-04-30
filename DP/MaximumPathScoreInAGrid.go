// LeetCode 3742 - Maximum Path Score in a Grid
// Time Complexity: O(m * n * k) | Space Complexity: O(m * n * k)
package main

func maxPathScore(grid [][]int, k int) int {
	rows := len(grid)
	cols := len(grid[0])
	negativeInfinity := -(1 << 30)

	memo := make([][][]int, rows)
	for row := 0; row < rows; row++ {
		memo[row] = make([][]int, cols)
		for col := 0; col < cols; col++ {
			memo[row][col] = make([]int, k+1)
			for remainingCost := 0; remainingCost <= k; remainingCost++ {
				memo[row][col][remainingCost] = -1
			}
		}
	}

	var dfs func(int, int, int) int
	dfs = func(row int, col int, remainingCost int) int {
		if row < 0 || col < 0 || remainingCost < 0 {
			return negativeInfinity
		}

		if row == 0 && col == 0 {
			return 0
		}

		if memo[row][col][remainingCost] != -1 {
			return memo[row][col][remainingCost]
		}

		score := grid[row][col]
		nextCost := remainingCost
		if grid[row][col] > 0 {
			nextCost--
		}

		score += maxInt(
			dfs(row-1, col, nextCost),
			dfs(row, col-1, nextCost),
		)
		memo[row][col][remainingCost] = score
		return score
	}

	answer := dfs(rows-1, cols-1, k)
	if answer < 0 {
		return -1
	}
	return answer
}

func maxInt(first int, second int) int {
	if first > second {
		return first
	}
	return second
}
