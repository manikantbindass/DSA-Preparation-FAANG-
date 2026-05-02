// LeetCode 788 - Rotated Digits
// Time Complexity: O(n log n) | Space Complexity: O(1)
public class RotatedDigits {
    private final int[] rotated = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

    public int rotatedDigits(int n) {
        int answer = 0;

        for (int value = 1; value <= n; value++) {
            if (isGood(value)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isGood(int value) {
        int rotatedValue = 0;
        int current = value;
        int place = 1;

        while (current > 0) {
            int digit = current % 10;
            if (rotated[digit] == -1) {
                return false;
            }

            rotatedValue = rotated[digit] * place + rotatedValue;
            place *= 10;
            current /= 10;
        }

        return value != rotatedValue;
    }
}
