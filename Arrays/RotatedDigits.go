// LeetCode 788 - Rotated Digits
// Time Complexity: O(n log n) | Space Complexity: O(1)
package main

func rotatedDigits(n int) int {
	rotated := []int{0, 1, 5, -1, -1, 2, 9, -1, 8, 6}
	answer := 0

	isGood := func(value int) bool {
		rotatedValue := 0
		current := value
		place := 1

		for current > 0 {
			digit := current % 10
			if rotated[digit] == -1 {
				return false
			}

			rotatedValue = rotated[digit]*place + rotatedValue
			place *= 10
			current /= 10
		}

		return value != rotatedValue
	}

	for value := 1; value <= n; value++ {
		if isGood(value) {
			answer++
		}
	}

	return answer
}
