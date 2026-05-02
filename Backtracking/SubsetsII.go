// LeetCode 90 - Subsets II
// Time Complexity: O(n * 2^n) | Space Complexity: O(n)
package backtracking

import "sort"

func subsetsWithDup(nums []int) (answer [][]int) {
	sort.Ints(nums)
	current := []int{}

	var dfs func(int)
	dfs = func(index int) {
		if index >= len(nums) {
			answer = append(answer, append([]int(nil), current...))
			return
		}

		current = append(current, nums[index])
		dfs(index + 1)
		value := current[len(current)-1]
		current = current[:len(current)-1]

		for index+1 < len(nums) && nums[index+1] == value {
			index++
		}

		dfs(index + 1)
	}

	dfs(0)
	return
}
