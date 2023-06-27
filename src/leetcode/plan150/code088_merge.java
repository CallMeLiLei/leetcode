package leetcode.plan150;

import java.util.Arrays;

public class code088_merge {

    /** 方法2 : 双指针
     * 比较最大的，谁大谁放数组最后面，指针前移，需要考虑到pos2指针依然大于0的情况
     *
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m - 1;
        int pos2 = n - 1;
        int total = m + n - 1;
        while (pos1 >= 0 && pos2 >= 0) {
            if (nums2[pos2] > nums1[pos1]) {
                nums1[total--] = nums2[pos2--];
            } else {
                nums1[total--] = nums1[pos1--];
            }
        }
        while (pos2 >= 0) {
            nums1[total--] = nums2[pos2--];
        }
    }

    /** 方法1  直接数组合并 然后排序*/
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
