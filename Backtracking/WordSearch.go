// LeetCode 79 - Word Search
// Time Complexity: O(m * n * 3^L) | Space Complexity: O(L)
package backtracking

func exist(board [][]byte, word string) bool {
	rows, cols := len(board), len(board[0])
	directions := []int{-1, 0, 1, 0, -1}

	var dfs func(int, int, int) bool
	dfs = func(row int, col int, index int) bool {
		if board[row][col] != word[index] {
			return false
		}

		if index == len(word)-1 {
			return true
		}

		saved := board[row][col]
		board[row][col] = '#'

		for direction := 0; direction < 4; direction++ {
			nextRow := row + directions[direction]
			nextCol := col + directions[direction+1]

			if nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols {
				continue
			}

			if board[nextRow][nextCol] == '#' {
				continue
			}

			if dfs(nextRow, nextCol, index+1) {
				board[row][col] = saved
				return true
			}
		}

		board[row][col] = saved
		return false
	}

	for row := 0; row < rows; row++ {
		for col := 0; col < cols; col++ {
			if dfs(row, col, 0) {
				return true
			}
		}
	}

	return false
}
