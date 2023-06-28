package leetcode.jzoffer;

/**
 * 数组中出现超过一半的数字
 * <p>
 * 摩尔消元法
 */
public class code0039_majorityElement {

    public int majorityElement(int[] nums) {
        Integer major = null;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) major = nums[i];
            count += (major == nums[i]) ? 1 : -1;
        }
        return major;
    }
}
