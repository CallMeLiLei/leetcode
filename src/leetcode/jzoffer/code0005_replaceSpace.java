package leetcode.jzoffer;

/**
 * 替换空格
 */
public class code0005_replaceSpace {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0 ; i < charArray.length; i++) {
            if (charArray[i] == ' '){
                sb.append("%20");
            }else {
                sb.append(charArray[i]);
            }

        }
        return sb.toString();
    }
}
