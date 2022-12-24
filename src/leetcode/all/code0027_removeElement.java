package leetcode.all;

/**
 * 移除元素
 */
public class code0027_removeElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
            } else {
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}
