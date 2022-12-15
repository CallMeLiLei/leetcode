package leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三树之和
 */
public class code0015_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nums.length - 1;
            while ( i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                }else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                }else {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]); // i和j都来到下一个不同的元素

                }
            }
        }
        return ans;
    }
}
