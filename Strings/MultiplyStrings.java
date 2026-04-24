// LeetCode 43 - Multiply Strings
// Time Complexity: O(m * n) | Space Complexity: O(m + n)
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] digits = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                digits[i + j + 1] += a * b;
            }
        }

        for (int i = digits.length - 1; i > 0; i--) {
            digits[i - 1] += digits[i] / 10;
            digits[i] %= 10;
        }

        int index = digits[0] == 0 ? 1 : 0;
        StringBuilder answer = new StringBuilder();
        while (index < digits.length) {
            answer.append(digits[index]);
            index++;
        }

        return answer.toString();
    }
}
