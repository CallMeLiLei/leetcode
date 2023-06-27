package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总数
 */
public class code0039_combinationSum {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrace(candidates, 0, target, new ArrayList<>());
        return ans;
    }

    private void backTrace(int[] candidates, int index, int target, ArrayList<Integer> list) {
        if (target < 0 || index >= candidates.length) return;

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTrace(candidates, i, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
