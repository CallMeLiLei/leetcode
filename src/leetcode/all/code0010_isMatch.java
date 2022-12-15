package leetcode.all;

/**
 * 正则表达式匹配
 */
public class code0010_isMatch {

    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (pArray[i] == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        /**
         * 三种情况 ：
         *        1、 s的第i位置和p的第j位置相同 则dp[i][j] = dp[i-1][j-1]
         *        2、 p的第j位置是.             则dp[i][j] = dp[i-1][j-1]
         *        3、 p的第j位置时*,题目保证第一个位置不会是* 则可能情况如下：
         *                     1) *一个字符都不匹配   dp[i][j] = dp[i][j - 2]
         *                     2) *只匹配一个字符     dp[i][j] = dp[i][j - 1]
         *                     3) *匹配多个字符       dp[i][j] = dp[i - 1][j]
         */
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (sArray[i] == pArray[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (pArray[j] == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (pArray[j] == '*') {
                    if (sArray[i] != pArray[j - 1] && pArray[j - 1] != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                    }
                }
            }

        }

        return dp[s.length()][p.length()];
    }
}
