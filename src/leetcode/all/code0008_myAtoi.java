package leetcode.all;

/**
 * 字符串转整数 考虑以下情景
 * 1、一个不合法的字符串应该是什么样的， ===> 不是以数字 和正负号开头
 * 2、
 */
public class code0008_myAtoi {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);  // 2147483647
        System.out.println(Integer.MIN_VALUE);  //-2147483648
        System.out.println(1 + Integer.MAX_VALUE); // -2147483648
        System.out.println(1L + Integer.MAX_VALUE); // 2147483648
        long i = 2147483648L;
        System.out.println((int)i);  //-2147483648
    }
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        char[] charArray = s.toCharArray();
        // 不是以数字，+ - 开头
        if (!Character.isDigit(charArray[0]) && charArray[0] != '+' && charArray[0] != '-') {
            return 0;
        }
        long ans = 0L;
        boolean neg = charArray[0] == '-';
        int i = !Character.isDigit(charArray[0]) ? 1 : 0;  // 判断第一个字符还是第二个字符是数字
        while (i < charArray.length && Character.isDigit(charArray[i])) {
            ans = ans * 10 + (charArray[i++] - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1 + Integer.MAX_VALUE; // Integer.MIN_VALUE
                break;
            }
        }
        return !neg ? (int) ans : (int) -ans;
    }
}
