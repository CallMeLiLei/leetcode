package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class code0022_generateParenthesis {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n,0,0,new StringBuilder());
        return ans;
    }

    public void generate(int n, int left, int right, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (left < n) {    // 填写左括号
            sb.append('(');
            generate(n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) { // 填写右括号
            sb.append(')');
            generate(n,left,right + 1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
