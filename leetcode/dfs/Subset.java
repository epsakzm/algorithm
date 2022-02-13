package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subset {

    void solve(int start, int[] nums, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; ++i) {
            list.add(nums[i]);
            solve(i + 1, nums, list, lists);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> subsets = new Subset().subsets(nums);
        for (List<Integer> list : subsets)
            System.out.println(list);
    }
}
