# LeetCode 49 - Group Anagrams
# Time Complexity: O(n * k log k) | Space Complexity: O(n * k)
from collections import defaultdict
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)

        for s in strs:
            key = "".join(sorted(s))
            groups[key].append(s)

        return list(groups.values())
