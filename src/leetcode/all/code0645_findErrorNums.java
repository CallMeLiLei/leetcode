package leetcode.all;

/**
 * 错误的集合
 */
public class code0645_findErrorNums {

    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1) {
                int index = nums[i] - 1;
                if (nums[i] == nums[index]) {
                    ans[0] = nums[i];
                    break;
                }
                swap(nums, i, index);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
