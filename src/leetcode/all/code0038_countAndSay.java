package leetcode.all;

/**
 * 外观数列
 */
public class code0038_countAndSay {

    public String countAndSay(int n) {

        String ans = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < ans.length(); j++) {
                int count = 1; //当前数出现了一次
                while (j + 1 < ans.length() && ans.charAt(j) == ans.charAt(j + 1)) {
                    count++; //当前这个字符出现了多次
                    j++;
                }
                sb.append(count).append(ans.charAt(j));
            }
            ans = sb.toString();
        }
        return ans;
    }
}
