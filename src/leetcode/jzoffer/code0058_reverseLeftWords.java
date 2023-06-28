package leetcode.jzoffer;

/**
 * 左旋转字符串
 */
public class code0058_reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        String s1 = s + s ;
        return s1.substring(n,s.length() + n);
    }
}
