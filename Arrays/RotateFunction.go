// LeetCode 396 - Rotate Function
// Time Complexity: O(n) | Space Complexity: O(1)
package main

func maxRotateFunction(nums []int) int {
	rotateValue := 0
	sum := 0
	n := len(nums)

	for index, value := range nums {
		rotateValue += index * value
		sum += value
	}

	answer := rotateValue
	for index := 1; index < n; index++ {
		rotateValue = rotateValue + sum - n*nums[n-index]
		if rotateValue > answer {
			answer = rotateValue
		}
	}

	return answer
}
