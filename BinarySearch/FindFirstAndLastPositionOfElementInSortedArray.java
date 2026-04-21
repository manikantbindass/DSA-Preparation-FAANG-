// LeetCode 34 - Find First and Last Position of Element in Sorted Array
// Time Complexity: O(log n) | Space Complexity: O(1)
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { boundary(nums, target, true), boundary(nums, target, false) };
    }

    private int boundary(int[] nums, int target, boolean first) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                answer = mid;
                if (first) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
