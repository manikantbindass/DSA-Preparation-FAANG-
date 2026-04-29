// LeetCode 51 - N-Queens
// Time Complexity: O(n!) | Space Complexity: O(n^2)
package main

func solveNQueens(n int) [][]string {
	answer := make([][]string, 0)
	columns := make([]int, n)
	diagonals := make([]int, n<<1)
	antiDiagonals := make([]int, n<<1)
	board := make([][]byte, n)

	for row := 0; row < n; row++ {
		board[row] = make([]byte, n)
		for col := 0; col < n; col++ {
			board[row][col] = '.'
		}
	}

	var backtrack func(row int)
	backtrack = func(row int) {
		if row == n {
			configuration := make([]string, n)
			for currentRow := 0; currentRow < n; currentRow++ {
				configuration[currentRow] = string(board[currentRow])
			}
			answer = append(answer, configuration)
			return
		}

		for col := 0; col < n; col++ {
			diagonalIndex := row + col
			antiDiagonalIndex := n - row + col

			if columns[col]+diagonals[diagonalIndex]+antiDiagonals[antiDiagonalIndex] != 0 {
				continue
			}

			board[row][col] = 'Q'
			columns[col] = 1
			diagonals[diagonalIndex] = 1
			antiDiagonals[antiDiagonalIndex] = 1

			backtrack(row + 1)

			board[row][col] = '.'
			columns[col] = 0
			diagonals[diagonalIndex] = 0
			antiDiagonals[antiDiagonalIndex] = 0
		}
	}

	backtrack(0)
	return answer
}
