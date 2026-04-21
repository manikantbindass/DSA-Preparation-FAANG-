// LeetCode 66 - Plus One
// Time Complexity: O(n) | Space Complexity: O(1), excluding returned carry array
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] answer = new int[digits.length + 1];
        answer[0] = 1;
        return answer;
    }
}
