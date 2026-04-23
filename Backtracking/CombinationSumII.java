// LeetCode 40 - Combination Sum II
// Time Complexity: O(2^n) worst case | Space Complexity: O(target)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private final List<List<Integer>> answer = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, target);
        return answer;
    }

    private void dfs(int start, int remain) {
        if (remain == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }
        if (start >= candidates.length || remain < candidates[start]) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            dfs(i + 1, remain - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
