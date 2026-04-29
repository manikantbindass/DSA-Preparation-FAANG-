# LeetCode 53 - Maximum Subarray
# Time Complexity: O(n) | Space Complexity: O(1)
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        answer = nums[0]
        best_ending_here = nums[0]

        for index in range(1, len(nums)):
            best_ending_here = max(best_ending_here, 0) + nums[index]
            answer = max(answer, best_ending_here)

        return answer
