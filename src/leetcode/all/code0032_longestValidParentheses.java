package leetcode.all;

/**
 * 最长有效括号
 */
public class code0032_longestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] charArray = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int ans = 0;
        // 如果是'('则dp[0]就是0  如果是右括号，则看dp[i-1]位置往前推了多少，匹配前面的'('
        for (int i = 1; i < s.length(); i++) {
            if (charArray[i] == ')') {
                int pre = i - dp[i - 1] - 1;  // 向前能推多少位置
                if (pre >= 0 && charArray[pre] == '(') {
                    dp[i] = 2 + dp[i - 1] + (pre > 0 ? dp[pre - 1] : 0);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
