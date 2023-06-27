package leetcode.all;

import java.util.ArrayList;
import java.util.List;

public class code216_combinationSum3 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrace(k, n, 1, new ArrayList<Integer>());
        return ans;
    }

    private void backTrace(int k, int n, int start, ArrayList<Integer> list) {
        if (list.size() == k || n <= 0) {
            if (list.size() == k && n == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);
            backTrace(k, n - i, i + 1, list); // i 从start开始然后在回溯中 i + 1 就是向后搜索
            list.remove(list.size() - 1);
        }
    }
}
