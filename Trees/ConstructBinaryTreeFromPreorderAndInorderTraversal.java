// LeetCode 105 - Construct Binary Tree from Preorder and Inorder Traversal
// Time Complexity: O(n) | Space Complexity: O(n)
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int[] preorder;
    private final Map<Integer, Integer> inorderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        this.preorder = preorder;

        for (int index = 0; index < length; index++) {
            inorderIndex.put(inorder[index], index);
        }

        return dfs(0, 0, length);
    }

    private TreeNode dfs(int preorderStart, int inorderStart, int size) {
        if (size <= 0) {
            return null;
        }

        int rootValue = preorder[preorderStart];
        int splitIndex = inorderIndex.get(rootValue);
        TreeNode left = dfs(preorderStart + 1, inorderStart, splitIndex - inorderStart);
        TreeNode right = dfs(
            preorderStart + 1 + splitIndex - inorderStart,
            splitIndex + 1,
            size - 1 - (splitIndex - inorderStart)
        );

        return new TreeNode(rootValue, left, right);
    }
}
