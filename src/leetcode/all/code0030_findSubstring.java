package leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 */
public class code0030_findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        if (s.length() == 0 || words.length == 0) return ans;
        for (String word : words) {
            if (!s.contains(word)) {
                return ans;
            }
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        int oneLen = words[0].length();
        int wordsLen = oneLen * words.length;

        if (wordsLen > s.length()) {
            return ans;
        }
        boolean flag = false;
        for (int i = 0; i < oneLen; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> subMap = new HashMap<>();
            while (right + oneLen <= s.length()) {
                String word = s.substring(right, right + oneLen);
                right += oneLen;
                if (!wordsMap.containsKey(word)) {
                    left = right;
                    subMap.clear();
                    count = 0;
                } else {
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    ++count;
                    while (subMap.getOrDefault(word, 0) > wordsMap.getOrDefault(word, 0)) {
                        String w = s.substring(left, left + oneLen);
                        subMap.put(w, subMap.getOrDefault(w, 0) - 1);
                        --count;
                        left += oneLen;
                    }
                    if (count == words.length) {
                        ans.add(left);
                    }

                }
            }
        }
        return ans;
    }
}
