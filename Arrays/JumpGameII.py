# LeetCode 45 - Jump Game II
# Time Complexity: O(n) | Space Complexity: O(1)
from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        jumps = 0
        farthest = 0
        current_end = 0

        for index in range(len(nums) - 1):
            farthest = max(farthest, index + nums[index])
            if current_end == index:
                jumps += 1
                current_end = farthest

        return jumps
