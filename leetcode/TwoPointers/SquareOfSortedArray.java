package leetcode.TwoPointers;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquareOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; ++i)
            answer[i] = nums[i] * nums[i];
        Arrays.sort(answer);
        return answer;
    }
}
