package leetcode.all;
/**
 * 二进制手表
 */

import java.util.ArrayList;
import java.util.List;

public class code0401_readBinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        // 枚举小时0 - 11 和 分钟 0 - 59   0:00---> 11:59
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (countOne(i) + countOne(j) == turnedOn) {
                    String temp = i + ":" + (j < 10 ? "0" + j : j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    /**
     * 统计二进制数字中1的个数
     *
     * @param n
     * @return
     */
    public int countOne(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
