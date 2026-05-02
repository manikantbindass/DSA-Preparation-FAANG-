# LeetCode 105 - Construct Binary Tree from Preorder and Inorder Traversal
# Time Complexity: O(n) | Space Complexity: O(n)
from typing import List, Optional


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_index = {value: index for index, value in enumerate(inorder)}

        def dfs(preorder_start: int, inorder_start: int, size: int) -> Optional[TreeNode]:
            if size <= 0:
                return None

            root_value = preorder[preorder_start]
            split_index = inorder_index[root_value]
            left = dfs(preorder_start + 1, inorder_start, split_index - inorder_start)
            right = dfs(
                preorder_start + 1 + split_index - inorder_start,
                split_index + 1,
                size - 1 - (split_index - inorder_start),
            )
            return TreeNode(root_value, left, right)

        return dfs(0, 0, len(preorder))
