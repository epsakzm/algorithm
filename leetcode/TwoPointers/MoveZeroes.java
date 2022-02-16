package leetcode.twopointers;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] != 0)
                nums[idx++] = nums[i];
        Arrays.fill(nums, idx, nums.length, 0);
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
