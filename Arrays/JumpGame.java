// LeetCode 55 - Jump Game
// Time Complexity: O(n) | Space Complexity: O(1)
public class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int index = 0; index < nums.length; index++) {
            if (farthest < index) {
                return false;
            }
            farthest = Math.max(farthest, index + nums[index]);
        }

        return true;
    }
}
