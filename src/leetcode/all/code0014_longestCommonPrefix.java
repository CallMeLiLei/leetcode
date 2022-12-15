package leetcode.all;

/**
 * 最长公共前缀
 */
public class code0014_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String min = strs[0];
        for (String str : strs) {
            if (str.length() < min.length()) {
                min = str;
            }
        }
        for (String str : strs) {
            while (!str.startsWith(min)){
                if (min.length() == 0) return "";
                min = min.substring(0,min.length() - 1);
            }
        }
        return min;
    }
}
