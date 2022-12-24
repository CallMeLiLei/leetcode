package leetcode.all;

/**
 * 字符串匹配
 */
public class code0028_strStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        char[] origin = haystack.toCharArray();
        char[] match = needle.toCharArray();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < origin.length - match.length + 1) {
            k = i;
            while (origin[i] == match[j]) {
                i++;
                j++;
                if (j == match.length) {
                    return k;
                }
            }
            i = k + 1;
            j = 0;
        }
        return -1;
    }
}
