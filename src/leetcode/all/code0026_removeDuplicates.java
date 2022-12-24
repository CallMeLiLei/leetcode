package leetcode.all;

/**
 * 删除有序数组中的重复项
 */
public class code0026_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int i = 1;
        int j = 1;
        while (j < nums.length) {
            if(nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
