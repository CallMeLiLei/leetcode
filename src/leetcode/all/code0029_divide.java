package leetcode.all;

/**
 * 两数相除
 */
public class code0029_divide {
    public int divide(int dividend, int divisor) {
        //dividend / divisor

        if (divisor == 1) return dividend;  // 被除数是1 直接返回除数
        if (divisor == -1 && dividend == Integer.MIN_VALUE) { // 被除数是-1  且 除数是最小值 则返回最大值
            return Integer.MAX_VALUE;
        }

        if (dividend < 0 && divisor < 0) {
            return divide(-(long) dividend, -(long) divisor); // 要转为long类型 且符号组合有四种
        } else if (dividend < 0 || divisor < 0) {
            return -divide(Math.abs((long) dividend), Math.abs((long) divisor));
        } else {
            return divide((long) dividend, (long) divisor);
        }
    }

    // 采取的是一个不断移位的操作
    public int divide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;   // base case
        }
        long sum = divisor;  // long类型
        int count = 1;
        while (dividend >= sum) {
            sum <<= 1;     // 被除数 不断 乘以2  然后判断除数是否依然大于被除数
            count <<= 1;   // 可以理解为近似商
        }
        sum >>>= 1;
        count >>>= 1;

        return count + divide(dividend - sum, divisor);
    }
}
