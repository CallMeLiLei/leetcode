package leetcode.all;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效的括号
 */
public class code0020_isValid {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : charArray) {
            if (c == '(') stack.push(')');   // 当字符是左括号 则在栈中加入右括号
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false; // 如果字符是右括号，则弹出栈中的元素是否一样
        }
        return stack.isEmpty();
    }
}
