package leetcode.all;
/**
 * Z字形变换
 */
import java.util.ArrayList;
import java.util.List;

public class code0006_convert {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder()); // 确定几行
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;   // 要换行
            i +=flag;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }
}
