package leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code0040_combinationSum2 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrace(candidates, 0, target, new ArrayList<>());
        return ans;
    }

    private void backTrace(int[] candidates, int index, int target, ArrayList<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            backTrace(candidates, i + 1, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
