package leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 */
public class code0018_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) return ans;
        Arrays.sort(nums);
        int len = nums.length;
        // k代表最左的指针
        for (int k = 0; k < len - 3; k++) {
            // 去重
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            // 计算最小值 最小值都大于0 后面也不可能有等于0的了
            long min = (long) nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min > target) {
                break;
            }

            //计算最大值 当前k位置下的最大值小于0  则直接k后移
            long max = (long) nums[k] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max < target) {
                continue;
            }
            //定义指针i 指向k后面一位
            for (int i = k + 1; i < len - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 定义指针j 指向 i + 1 , h指向数组末尾
                int j = i + 1;
                int h = len - 1;
                long min1 = (long) nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min1 > target) {
                    break;
                }
                long max1 = (long) nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max1 < target) {
                    continue;
                }

                while (j < h) {
                    long sum = (long) nums[k] + nums[i] + nums[j] + nums[h];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        h--;
                        while (j < h && nums[j] == nums[j - 1]) j++;   // j向后指向不重复的下一个元素
                        while (j < h && nums[h] == nums[h + 1]) h--;  // h向前指向不重复的前一个元素
                    } else if (sum > target) {
                        h--;
                        while (j < h && nums[h] == nums[h + 1]) h--;
                    } else {
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) j++;
                    }
                }
            }
        }
        return ans;
    }
}
