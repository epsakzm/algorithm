package leetcode.twopointers;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumSorted {

    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0, ptr2 = numbers.length - 1;

        while (true) {
            int sum = numbers[ptr1] + numbers[ptr2];
            if (sum == target)
                return new int[] { ptr1 + 1, ptr2 + 1 };
            else if (sum < target)
                ++ptr1;
            else
                --ptr2;
        }
    }

    public static void main(String[] args) {

    }
}
