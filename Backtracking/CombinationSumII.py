# LeetCode 40 - Combination Sum II
# Time Complexity: O(2^n) worst case | Space Complexity: O(target)
from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        answer = []
        path = []

        def dfs(start: int, remain: int) -> None:
            if remain == 0:
                answer.append(path[:])
                return
            if start >= len(candidates) or remain < candidates[start]:
                return

            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                path.append(candidates[i])
                dfs(i + 1, remain - candidates[i])
                path.pop()

        dfs(0, target)
        return answer
