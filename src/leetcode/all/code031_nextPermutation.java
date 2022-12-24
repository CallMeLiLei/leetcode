package leetcode.all;

/**
 * 下一个排列
 */
public class code031_nextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            if (j >= 0) {
                swap(nums, i, j);
            }
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
