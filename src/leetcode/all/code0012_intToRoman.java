package leetcode.all;

/**
 * 整数转罗马数字
 */
public class code0012_intToRoman {
    public String intToRoman(int num) {
        int[] number = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbol = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        int index = number.length -1 ;
        while (num >= 0 && index >= 0) {
            if (num >= number[index]) {
                sb.append(symbol[index]);
                num -= number[index];
            } else {
                index--;
            }
        }
        return sb.toString();
    }
}
