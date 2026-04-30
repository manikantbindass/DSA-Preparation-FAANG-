// LeetCode 54 - Spiral Matrix
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
package main

func spiralOrder(matrix [][]int) []int {
	rows := len(matrix)
	cols := len(matrix[0])
	directions := []int{0, 1, 0, -1, 0}
	visited := make([][]bool, rows)
	answer := make([]int, 0, rows*cols)

	for row := 0; row < rows; row++ {
		visited[row] = make([]bool, cols)
	}

	row := 0
	col := 0
	direction := 0

	for remaining := rows * cols; remaining > 0; remaining-- {
		answer = append(answer, matrix[row][col])
		visited[row][col] = true

		nextRow := row + directions[direction]
		nextCol := col + directions[direction+1]
		if nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol] {
			direction = (direction + 1) % 4
		}

		row += directions[direction]
		col += directions[direction+1]
	}

	return answer
}
