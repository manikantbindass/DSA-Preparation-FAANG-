# LeetCode 55 - Jump Game
# Time Complexity: O(n) | Space Complexity: O(1)
from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        farthest = 0

        for index, value in enumerate(nums):
            if farthest < index:
                return False
            farthest = max(farthest, index + value)

        return True
