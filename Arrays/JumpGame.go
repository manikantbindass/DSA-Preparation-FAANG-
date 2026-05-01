// LeetCode 55 - Jump Game
// Time Complexity: O(n) | Space Complexity: O(1)
package main

func canJump(nums []int) bool {
	farthest := 0

	for index, value := range nums {
		if farthest < index {
			return false
		}
		if index+value > farthest {
			farthest = index + value
		}
	}

	return true
}
