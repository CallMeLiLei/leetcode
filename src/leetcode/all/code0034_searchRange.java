package leetcode.all;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class code0034_searchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int i = search(nums, target);
        int j = search(nums, target + 1);
        if (i == nums.length || nums[i] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{i, j - 1};
        }
    }

    // 找到大于等于一个数最左边的位置
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
