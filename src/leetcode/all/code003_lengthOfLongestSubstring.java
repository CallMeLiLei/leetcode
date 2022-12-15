package leetcode.all;

import java.util.Arrays;

/**
 * 无重复最长子串
 */
public class code003_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int pre = -1;  // 上一个相同字符出现的位置
        int len = 0;   // 当前的长度
        int max = 0;   // 最大的长度
        int[] map = new int[128];
        Arrays.fill(map, -1);
        for (int i = 0; i < charArray.length; i++) {
            pre = Math.max(pre, map[charArray[i]]); // 上一个相同字符出现的位置
            len = i - pre;  // 计算当前无重复子串的长度
            max = Math.max(max, len);
            map[charArray[i]] = i;  // 该字符最后一次出现的位置
        }
        return max;
    }
}
