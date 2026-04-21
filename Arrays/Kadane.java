// Kadane's Algorithm - Maximum Subarray Sum
// Time Complexity: O(n) | Space Complexity: O(1)
public class Kadane {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int current = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }

        return best;
    }
}
