# LeetCode 43 - Multiply Strings
# Time Complexity: O(m * n) | Space Complexity: O(m + n)


class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"

        m = len(num1)
        n = len(num2)
        digits = [0] * (m + n)

        for i in range(m - 1, -1, -1):
            a = ord(num1[i]) - ord("0")
            for j in range(n - 1, -1, -1):
                b = ord(num2[j]) - ord("0")
                digits[i + j + 1] += a * b

        for i in range(len(digits) - 1, 0, -1):
            digits[i - 1] += digits[i] // 10
            digits[i] %= 10

        index = 1 if digits[0] == 0 else 0
        return "".join(str(digit) for digit in digits[index:])
