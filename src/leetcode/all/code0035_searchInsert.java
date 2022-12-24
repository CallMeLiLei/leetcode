package leetcode.all;

/**
 * 搜索插入位置
 */
public class code0035_searchInsert {
    public int searchInsert(int[] nums, int target) {
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
