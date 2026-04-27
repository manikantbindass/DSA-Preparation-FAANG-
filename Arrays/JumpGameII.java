// LeetCode 45 - Jump Game II
// Time Complexity: O(n) | Space Complexity: O(1)
public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;

        for (int index = 0; index < nums.length - 1; index++) {
            farthest = Math.max(farthest, index + nums[index]);
            if (currentEnd == index) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
