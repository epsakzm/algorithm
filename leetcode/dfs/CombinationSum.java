package leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> list = new LinkedList<>();

    private void comb(int start, int sum, int[] candidates, int target) {
        if (sum >= target) {
            if (sum == target)
                answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            list.add(candidates[i]);
            comb(i, sum + candidates[i], candidates, target);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        comb(0, 0, candidates, target);
        return answer;
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        for (List<Integer> lst : new CombinationSum().combinationSum(candidates, target))
            System.out.print(lst + " ");
    }
}
