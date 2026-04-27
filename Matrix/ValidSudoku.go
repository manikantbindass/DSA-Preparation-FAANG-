// LeetCode 36 - Valid Sudoku
// Time Complexity: O(1) | Space Complexity: O(1)
package main

func isValidSudoku(board [][]byte) bool {
	rows := make([][]bool, 9)
	cols := make([][]bool, 9)
	boxes := make([][]bool, 9)
	for index := 0; index < 9; index++ {
		rows[index] = make([]bool, 9)
		cols[index] = make([]bool, 9)
		boxes[index] = make([]bool, 9)
	}

	for row := 0; row < 9; row++ {
		for col := 0; col < 9; col++ {
			cell := board[row][col]
			if cell == '.' {
				continue
			}

			digit := int(cell - '1')
			box := (row/3)*3 + col/3
			if rows[row][digit] || cols[col][digit] || boxes[box][digit] {
				return false
			}

			rows[row][digit] = true
			cols[col][digit] = true
			boxes[box][digit] = true
		}
	}

	return true
}
