// LeetCode 68 - Text Justification
// Time Complexity: O(total characters) | Space Complexity: O(maxWidth)
import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int lineStart = index;
            int lineLength = words[index].length();
            index++;

            while (index < words.length && lineLength + 1 + words[index].length() <= maxWidth) {
                lineLength += 1 + words[index].length();
                index++;
            }

            lines.add(buildLine(words, lineStart, index - 1, lineLength, maxWidth, index == words.length));
        }

        return lines;
    }

    private String buildLine(String[] words, int start, int end, int lineLength, int maxWidth, boolean lastLine) {
        int wordCount = end - start + 1;
        if (wordCount == 1 || lastLine) {
            StringBuilder line = new StringBuilder(words[start]);
            for (int i = start + 1; i <= end; i++) {
                line.append(' ').append(words[i]);
            }
            while (line.length() < maxWidth) {
                line.append(' ');
            }
            return line.toString();
        }

        int totalWordChars = lineLength - (wordCount - 1);
        int totalSpaces = maxWidth - totalWordChars;
        int gaps = wordCount - 1;
        int baseSpaces = totalSpaces / gaps;
        int extraSpaces = totalSpaces % gaps;
        StringBuilder line = new StringBuilder();

        for (int i = start; i <= end; i++) {
            line.append(words[i]);
            if (i < end) {
                int spaces = baseSpaces + (i - start < extraSpaces ? 1 : 0);
                line.append(" ".repeat(spaces));
            }
        }

        return line.toString();
    }
}
