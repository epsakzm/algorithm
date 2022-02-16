package leetcode.twopointers;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int rotate = k % nums.length;
        if (rotate == 0)
            return;
        int cut = nums.length - rotate;
        int[] front = Arrays.copyOfRange(nums, 0, cut);
        int[] back = Arrays.copyOfRange(nums, cut, nums.length);
        System.arraycopy(back, 0, nums, 0, back.length);
        System.arraycopy(front, 0, nums, rotate, front.length);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 6;
        new RotateArray().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
