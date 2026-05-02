// LeetCode 105 - Construct Binary Tree from Preorder and Inorder Traversal
// Time Complexity: O(n) | Space Complexity: O(n)
package main

func buildTree(preorder []int, inorder []int) *TreeNode {
	inorderIndex := make(map[int]int, len(inorder))

	for index, value := range inorder {
		inorderIndex[value] = index
	}

	var dfs func(int, int, int) *TreeNode
	dfs = func(preorderStart int, inorderStart int, size int) *TreeNode {
		if size <= 0 {
			return nil
		}

		rootValue := preorder[preorderStart]
		splitIndex := inorderIndex[rootValue]
		left := dfs(preorderStart+1, inorderStart, splitIndex-inorderStart)
		right := dfs(
			preorderStart+1+splitIndex-inorderStart,
			splitIndex+1,
			size-1-(splitIndex-inorderStart),
		)

		return &TreeNode{Val: rootValue, Left: left, Right: right}
	}

	return dfs(0, 0, len(preorder))
}
