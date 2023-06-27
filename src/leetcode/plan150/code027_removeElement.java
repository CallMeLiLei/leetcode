package leetcode.plan150;

public class code027_removeElement {

    public int removeElement(int[] nums, int val) {
        int ans = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[ans++] = nums[i++];
            }else {
                i++;
            }
        }
        return ans;
    }
}
