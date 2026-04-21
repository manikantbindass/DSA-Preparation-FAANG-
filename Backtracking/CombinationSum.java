// LeetCode 39 - Combination Sum
// Time Complexity: O(2^target) worst case | Space Complexity: O(target)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> answer) {
        if (remain == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= remain; i++) {
            path.add(candidates[i]);
            dfs(candidates, remain - candidates[i], i, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
