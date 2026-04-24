// LeetCode 43 - Multiply Strings
// Time Complexity: O(m * n) | Space Complexity: O(m + n)
package main

func multiply(num1 string, num2 string) string {
	if num1 == "0" || num2 == "0" {
		return "0"
	}

	m := len(num1)
	n := len(num2)
	digits := make([]int, m+n)

	for i := m - 1; i >= 0; i-- {
		a := int(num1[i] - '0')
		for j := n - 1; j >= 0; j-- {
			b := int(num2[j] - '0')
			digits[i+j+1] += a * b
		}
	}

	for i := len(digits) - 1; i > 0; i-- {
		digits[i-1] += digits[i] / 10
		digits[i] %= 10
	}

	index := 0
	if digits[0] == 0 {
		index = 1
	}

	answer := make([]byte, 0, len(digits)-index)
	for ; index < len(digits); index++ {
		answer = append(answer, byte(digits[index]+'0'))
	}

	return string(answer)
}
