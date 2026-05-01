// LeetCode 396 - Rotate Function
// Time Complexity: O(n) | Space Complexity: O(1)
public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int rotateValue = 0;
        int sum = 0;
        int n = nums.length;

        for (int index = 0; index < n; index++) {
            rotateValue += index * nums[index];
            sum += nums[index];
        }

        int answer = rotateValue;
        for (int index = 1; index < n; index++) {
            rotateValue = rotateValue + sum - n * nums[n - index];
            answer = Math.max(answer, rotateValue);
        }

        return answer;
    }
}
