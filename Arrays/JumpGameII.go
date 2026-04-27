// LeetCode 45 - Jump Game II
// Time Complexity: O(n) | Space Complexity: O(1)
package main

func jump(nums []int) int {
	jumps := 0
	farthest := 0
	currentEnd := 0

	for index := 0; index < len(nums)-1; index++ {
		if index+nums[index] > farthest {
			farthest = index + nums[index]
		}

		if currentEnd == index {
			jumps++
			currentEnd = farthest
		}
	}

	return jumps
}
