package leetcode.all;

/**
 * 整数反转
 */
public class code007_reverse {

    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return (int) ans == ans ? (int) ans : 0;
    }
}
