// LeetCode 80 - Remove Duplicates from Sorted Array II
// Time Complexity: O(n) | Space Complexity: O(1)
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int write = 0;

        for (int num : nums) {
            if (write < 2 || num != nums[write - 2]) {
                nums[write++] = num;
            }
        }

        return write;
    }
}
