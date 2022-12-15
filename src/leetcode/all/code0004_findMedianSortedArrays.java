package leetcode.all;

/**
 * 寻找两个正序数组的中位数
 * 难度很大
 */
public class code0004_findMedianSortedArrays {

    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int size = arr1.length + arr2.length;
        boolean even = (size & 1) == 0;
        if (arr1.length != 0 && arr2.length != 0) {
            if (even) {
                return (double)(findKthNum(arr1, arr2, size / 2) +
                        findKthNum(arr1, arr2, size / 2 + 1))/2;
            }else {
                return findKthNum(arr1, arr2, size / 2 + 1);
            }
        }else if (arr1.length != 0) {
            if (even) {
                return (double)(arr1[(size - 1) / 2] + arr1[size / 2]) / 2;
            }else {
                return arr1[size / 2];
            }
        }else if (arr2.length != 0) {
            if (even) {
                return (double)(arr2[(size - 1) / 2] + arr2[size / 2]) / 2;
            }else {
                return arr2[size / 2];
            }
        }else {
            return 0;
        }
    }

    //找到两个排序数组中第k小的数
    private int findKthNum(int[] arr1,int[] arr2,int kth) {
        int[] longs = arr1.length >= arr2.length ? arr1 : arr2;
        int[] shorts = arr1.length < arr2.length ? arr1 : arr2;
        int l = longs.length;
        int s = shorts.length;
        if (kth <= s) {
            return getUpMedian(shorts, 0, kth - 1, longs,0, kth-1);
        }
        if (kth > l) {
            if (shorts[kth - l - 1] >= longs[l - 1]) {
                return shorts[kth - l -1];
            }
            if (longs[kth -s - 1] >= shorts[s - 1]) {
                return longs[kth - s - 1];
            }
            return getUpMedian(shorts, kth - l, s -1, longs, kth -s, l - 1);
        }
        if (longs[kth - s- 1] >= shorts[s - 1]) {
            return longs[kth - s - 1];
        }
        return getUpMedian(shorts, 0, s - 1, longs, kth -s , kth - 1);
    }

    //返回两个长度相等排序数组的上中位数
    private int getUpMedian(int [] arr1,int start1,int end1,int[] arr2,int start2,int end2) {
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;  // 元素个数为偶数的情况下 offset + 1;
        while (start1 < end1) {
            mid1 = (start1 + end1) /2 ;
            mid2 = (start2 + end2) / 2;
            offset = ((end1 - start1 + 1)) % 2 == 0 ? 1 : 0;
            if (arr1[mid1] > arr2[mid2]) {
                end1 = mid1;
                start2 = mid2 + offset;
            }else if (arr1[mid1] < arr2[mid2]) {
                end2 = mid2;
                start1 = mid1 + offset;
            }else {
                return arr1[mid1];
            }
        }
        return Math.min(arr1[start1],arr2[start2]);
    }
}
