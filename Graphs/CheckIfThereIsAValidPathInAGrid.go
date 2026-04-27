// LeetCode 1391 - Check if There is a Valid Path in a Grid
// Time Complexity: O(m * n * alpha(m * n)) | Space Complexity: O(m * n)
package main

func hasValidPath(grid [][]int) bool {
	rows := len(grid)
	cols := len(grid[0])
	parent := make([]int, rows*cols)

	for index := range parent {
		parent[index] = index
	}

	var find func(int) int
	find = func(node int) int {
		if parent[node] != node {
			parent[node] = find(parent[node])
		}
		return parent[node]
	}

	union := func(first int, second int) {
		parent[find(first)] = find(second)
	}

	connectLeft := func(row int, col int) {
		if col > 0 {
			neighbor := grid[row][col-1]
			if neighbor == 1 || neighbor == 4 || neighbor == 6 {
				union(row*cols+col, row*cols+col-1)
			}
		}
	}

	connectRight := func(row int, col int) {
		if col < cols-1 {
			neighbor := grid[row][col+1]
			if neighbor == 1 || neighbor == 3 || neighbor == 5 {
				union(row*cols+col, row*cols+col+1)
			}
		}
	}

	connectUp := func(row int, col int) {
		if row > 0 {
			neighbor := grid[row-1][col]
			if neighbor == 2 || neighbor == 3 || neighbor == 4 {
				union(row*cols+col, (row-1)*cols+col)
			}
		}
	}

	connectDown := func(row int, col int) {
		if row < rows-1 {
			neighbor := grid[row+1][col]
			if neighbor == 2 || neighbor == 5 || neighbor == 6 {
				union(row*cols+col, (row+1)*cols+col)
			}
		}
	}

	for row := 0; row < rows; row++ {
		for col := 0; col < cols; col++ {
			street := grid[row][col]
			if street == 1 {
				connectLeft(row, col)
				connectRight(row, col)
			} else if street == 2 {
				connectUp(row, col)
				connectDown(row, col)
			} else if street == 3 {
				connectLeft(row, col)
				connectDown(row, col)
			} else if street == 4 {
				connectRight(row, col)
				connectDown(row, col)
			} else if street == 5 {
				connectLeft(row, col)
				connectUp(row, col)
			} else {
				connectRight(row, col)
				connectUp(row, col)
			}
		}
	}

	return find(0) == find(rows*cols-1)
}
