// LeetCode 90 - Subsets II
// Time Complexity: O(n * 2^n) | Space Complexity: O(n)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    private final List<List<Integer>> answer = new ArrayList<>();
    private final List<Integer> current = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        return answer;
    }

    private void dfs(int index) {
        if (index >= nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        dfs(index + 1);
        int value = current.remove(current.size() - 1);

        while (index + 1 < nums.length && nums[index + 1] == value) {
            index++;
        }

        dfs(index + 1);
    }
}
