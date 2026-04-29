// LeetCode 53 - Maximum Subarray
// Time Complexity: O(n) | Space Complexity: O(1)
package main

func maxSubArray(nums []int) int {
	answer := nums[0]
	bestEndingHere := nums[0]

	for index := 1; index < len(nums); index++ {
		if bestEndingHere < 0 {
			bestEndingHere = nums[index]
		} else {
			bestEndingHere += nums[index]
		}
		if bestEndingHere > answer {
			answer = bestEndingHere
		}
	}

	return answer
}
