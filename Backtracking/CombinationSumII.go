// LeetCode 40 - Combination Sum II
// Time Complexity: O(2^n) worst case | Space Complexity: O(target)
package main

import "sort"

func combinationSum2(candidates []int, target int) [][]int {
	sort.Ints(candidates)
	answer := make([][]int, 0)
	path := make([]int, 0)

	var dfs func(start, remain int)
	dfs = func(start, remain int) {
		if remain == 0 {
			combo := make([]int, len(path))
			copy(combo, path)
			answer = append(answer, combo)
			return
		}
		if start >= len(candidates) || remain < candidates[start] {
			return
		}

		for i := start; i < len(candidates); i++ {
			if i > start && candidates[i] == candidates[i-1] {
				continue
			}
			path = append(path, candidates[i])
			dfs(i+1, remain-candidates[i])
			path = path[:len(path)-1]
		}
	}

	dfs(0, target)
	return answer
}
