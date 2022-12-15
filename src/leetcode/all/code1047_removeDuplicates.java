package leetcode.all;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除字符串中所有相邻重复项
 * 为什么我想着用递归 ?  栈不是更好的数据结构吗？？
 */
public class code1047_removeDuplicates {
    public String removeDuplicates1(String s) {
        char[] charArray = s.toCharArray();
        int top = -1;
        for (int i = 0 ; i < s.length(); i++) {
            if (top == -1 || charArray[top] != charArray[i]) {
                charArray[++top] = charArray[i];
            }else{
                top--;
            }
        }
        return String.valueOf(charArray,0,top + 1);
    }
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();  // deque比stack效率要高
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (stack.isEmpty()) {
                stack.push(c);
            }else if (stack.peek() != c) {
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
