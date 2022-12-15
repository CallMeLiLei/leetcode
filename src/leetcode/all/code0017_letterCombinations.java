package leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 */
public class code0017_letterCombinations {

    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        Map<Character, String> letter = new HashMap() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(digits, new StringBuilder(), 0, letter);
        return ans;
    }

    private void dfs(String digits, StringBuilder sb, int index, Map<Character, String> letter) {

        if (sb.length() == digits.length()) {
            ans.add(new String(sb));
            return;
        }

        String s = letter.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(digits, sb, index + 1, letter);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
