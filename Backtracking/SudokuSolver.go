// LeetCode 37 - Sudoku Solver
// Time Complexity: O(9^m) | Space Complexity: O(m)
package main

func solveSudoku(board [][]byte) {
	emptyCells := make([][2]int, 0)
	rows := [9][9]bool{}
	cols := [9][9]bool{}
	boxes := [3][3][9]bool{}
	solved := false

	for row := 0; row < 9; row++ {
		for col := 0; col < 9; col++ {
			if board[row][col] == '.' {
				emptyCells = append(emptyCells, [2]int{row, col})
				continue
			}

			digit := int(board[row][col] - '1')
			rows[row][digit] = true
			cols[col][digit] = true
			boxes[row/3][col/3][digit] = true
		}
	}

	var backtrack func(int)
	backtrack = func(index int) {
		if index == len(emptyCells) {
			solved = true
			return
		}

		row := emptyCells[index][0]
		col := emptyCells[index][1]

		for digit := 0; digit < 9; digit++ {
			if rows[row][digit] || cols[col][digit] || boxes[row/3][col/3][digit] {
				continue
			}

			rows[row][digit] = true
			cols[col][digit] = true
			boxes[row/3][col/3][digit] = true
			board[row][col] = byte('1' + digit)

			backtrack(index + 1)
			if solved {
				return
			}

			rows[row][digit] = false
			cols[col][digit] = false
			boxes[row/3][col/3][digit] = false
			board[row][col] = '.'
		}
	}

	backtrack(0)
}
