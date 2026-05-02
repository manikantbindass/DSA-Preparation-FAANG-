# LeetCode 90 - Subsets II
# Time Complexity: O(n * 2^n) | Space Complexity: O(n)
from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        answer: List[List[int]] = []
        current: List[int] = []

        def dfs(index: int) -> None:
            if index >= len(nums):
                answer.append(current[:])
                return

            current.append(nums[index])
            dfs(index + 1)
            value = current.pop()

            while index + 1 < len(nums) and nums[index + 1] == value:
                index += 1

            dfs(index + 1)

        dfs(0)
        return answer
