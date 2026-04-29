// LeetCode 3225 - Maximum Score From Grid Operations
// Time Complexity: O(n^3) | Space Complexity: O(n^3)
package main

func maximumScore(grid [][]int) int64 {
	n := len(grid)
	if n == 1 {
		return 0
	}

	dp := make([][][]int64, n)
	for col := range dp {
		dp[col] = make([][]int64, n+1)
		for currentHeight := range dp[col] {
			dp[col][currentHeight] = make([]int64, n+1)
		}
	}

	prevMax := make([][]int64, n+1)
	prevSuffixMax := make([][]int64, n+1)
	for index := 0; index <= n; index++ {
		prevMax[index] = make([]int64, n+1)
		prevSuffixMax[index] = make([]int64, n+1)
	}

	columnPrefixSum := make([][]int64, n)
	for col := 0; col < n; col++ {
		columnPrefixSum[col] = make([]int64, n+1)
		for row := 1; row <= n; row++ {
			columnPrefixSum[col][row] = columnPrefixSum[col][row-1] + int64(grid[row-1][col])
		}
	}

	for col := 1; col < n; col++ {
		for currentHeight := 0; currentHeight <= n; currentHeight++ {
			for previousHeight := 0; previousHeight <= n; previousHeight++ {
				if currentHeight <= previousHeight {
					extraScore := columnPrefixSum[col][previousHeight] - columnPrefixSum[col][currentHeight]
					dp[col][currentHeight][previousHeight] = maxInt64(
						dp[col][currentHeight][previousHeight],
						prevSuffixMax[previousHeight][0]+extraScore,
					)
				} else {
					extraScore := columnPrefixSum[col-1][currentHeight] - columnPrefixSum[col-1][previousHeight]
					dp[col][currentHeight][previousHeight] = maxInt64(
						dp[col][currentHeight][previousHeight],
						maxInt64(
							prevSuffixMax[previousHeight][currentHeight],
							prevMax[previousHeight][currentHeight]+extraScore,
						),
					)
				}
			}
		}

		for currentHeight := 0; currentHeight <= n; currentHeight++ {
			prevMax[currentHeight][0] = dp[col][currentHeight][0]
			for previousHeight := 1; previousHeight <= n; previousHeight++ {
				var penalty int64
				if previousHeight > currentHeight {
					penalty = columnPrefixSum[col][previousHeight] - columnPrefixSum[col][currentHeight]
				}
				prevMax[currentHeight][previousHeight] = maxInt64(
					prevMax[currentHeight][previousHeight-1],
					dp[col][currentHeight][previousHeight]-penalty,
				)
			}

			prevSuffixMax[currentHeight][n] = dp[col][currentHeight][n]
			for previousHeight := n - 1; previousHeight >= 0; previousHeight-- {
				prevSuffixMax[currentHeight][previousHeight] = maxInt64(
					prevSuffixMax[currentHeight][previousHeight+1],
					dp[col][currentHeight][previousHeight],
				)
			}
		}
	}

	var answer int64
	for height := 0; height <= n; height++ {
		answer = maxInt64(answer, maxInt64(dp[n-1][n][height], dp[n-1][0][height]))
	}

	return answer
}

func maxInt64(first int64, second int64) int64 {
	if first > second {
		return first
	}
	return second
}
