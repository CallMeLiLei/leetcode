package leetcode.all;

/**
 * 盛水最多的容器
 */
public class code0011_maxArea {

    public int maxArea(int[] height) {
        int max = 0;
        int high = height.length - 1;
        int low = 0;
        while (low < high) {
            if (height[low] < height[high]) {
                max = Math.max(max, (high - low) * (Math.min(height[high], height[low++])));
            } else {
                max = Math.max(max, (high - low) * (Math.min(height[high--], height[low])));
            }
        }
        return max;
    }
}
