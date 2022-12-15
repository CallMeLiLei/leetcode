package leetcode.all;

/**
 * 最长回文子串
 */
public class code005_longestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() == 0) return " ";
        char[] str = s.toCharArray();
        int[] index = new int[2];  // 使用数组收集答案
        for (int i = 0; i < s.length(); i++) {
            i = findLongestString(str, i, index);  // 相同的字母一定是回文
        }
        return s.substring(index[0], index[1] + 1);
    }

    public int findLongestString(char[] str, int low, int[] index) {
        int high = low;
        while (high < str.length - 1 && str[high] == str[high + 1]) {
            high++;  // 跳过相同的 因为相同的字符在当前位置下一定是回文
        }
        int ans = high;
        // 从当前位置向两边扩散
        while (low >= 1 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        // 收集答案
        while (high - low > index[1] - index[0]) {
            index[0] = low;
            index[1] = high;
        }
        return ans;  // 返回下一个未重复字符的位置
    }
}
