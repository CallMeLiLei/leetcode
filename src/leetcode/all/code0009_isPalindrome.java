package leetcode.all;

/**
 * 回文数
 */
public class code0009_isPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {
            if (charArray[i] == charArray[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

