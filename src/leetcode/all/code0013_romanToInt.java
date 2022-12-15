package leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马转整数
 */
public class code0013_romanToInt {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};  // HashMap在构造中直接加入数据

    /*
    建立hashmap的映射，对字符串从左到右遍历，如果当前字符代表的值不小于其右边，就加上
    否则就减去
     */
    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = map.get(charArray[i]);
            if (i < n - 1 && value < map.get(charArray[i + 1])) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
