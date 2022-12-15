package leetcode.all;

import java.util.Arrays;

/**
 * 最接近的三树之和
 */
public class code0016_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++){
            int l =  i + 1, r = nums.length- 1;
            while (l < r) {
                int threeNum = nums[l] + nums[i] + nums[r];
                if (Math.abs(threeNum -target) < Math.abs(closeNum - target)){
                    closeNum= threeNum;
                }

                if (threeNum > target) {
                    r--;
                }else if (threeNum < target) {
                    l++;
                }else {
                    return target;
                }
            }
        }
        return closeNum;
    }
}
