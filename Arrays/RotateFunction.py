# LeetCode 396 - Rotate Function
# Time Complexity: O(n) | Space Complexity: O(1)
from typing import List


class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        rotate_value = 0
        total = 0
        n = len(nums)

        for index, value in enumerate(nums):
            rotate_value += index * value
            total += value

        answer = rotate_value
        for index in range(1, n):
            rotate_value = rotate_value + total - n * nums[n - index]
            answer = max(answer, rotate_value)

        return answer
