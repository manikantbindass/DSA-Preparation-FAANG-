// LeetCode 49 - Group Anagrams
// Time Complexity: O(n * k log k) | Space Complexity: O(n * k)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            groups.computeIfAbsent(key, value -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
