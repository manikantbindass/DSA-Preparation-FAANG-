# LeetCode 788 - Rotated Digits
# Time Complexity: O(n log n) | Space Complexity: O(1)
class Solution:
    def rotatedDigits(self, n: int) -> int:
        rotated = [0, 1, 5, -1, -1, 2, 9, -1, 8, 6]
        answer = 0

        def is_good(value: int) -> bool:
            rotated_value = 0
            current = value
            place = 1

            while current > 0:
                digit = current % 10
                if rotated[digit] == -1:
                    return False

                rotated_value = rotated[digit] * place + rotated_value
                place *= 10
                current //= 10

            return value != rotated_value

        for value in range(1, n + 1):
            if is_good(value):
                answer += 1

        return answer
