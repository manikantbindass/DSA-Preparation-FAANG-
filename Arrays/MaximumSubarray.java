// LeetCode 53 - Maximum Subarray
// Time Complexity: O(n) | Space Complexity: O(1)
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int answer = nums[0];
        int bestEndingHere = nums[0];

        for (int index = 1; index < nums.length; index++) {
            bestEndingHere = Math.max(bestEndingHere, 0) + nums[index];
            answer = Math.max(answer, bestEndingHere);
        }

        return answer;
    }
}
