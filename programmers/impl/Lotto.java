package programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/77484
public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {
        int zeros = (int) Arrays.stream(lottos).filter(i -> i == 0).count();

        int matched = (int) Arrays.stream(lottos).filter(i -> match(i, win_nums)).count();
        int min = Math.min(7 - matched, 7 - (matched + zeros));
        int max = Math.max(7 - matched, 7 - (matched + zeros));
        return new int[] { min == 0 ? 1 : min == 7 ? 6 : min, max == 7 ? 6 : max };
    }

    private boolean match(int num, int[] win_nums) {
        for (int win : win_nums)
            if (num == win)
                return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] lottos = {
                { 44, 1, 0, 0, 31, 25 },
                { 0, 0, 0, 0, 0, 0 },
                { 45, 4, 35, 20, 3, 9 },
                { 1, 2, 3, 4, 5, 6 }
        };
        int[][] win_nums = {
                { 31, 10, 45, 1, 6, 19 },
                { 38, 19, 20, 40, 15, 25 },
                { 20, 9, 3, 45, 4, 35 },
                { 7, 8, 9, 10, 11, 12 }
        };
        for (int i = 0; i < 4; ++i)
            System.out.println(Arrays.toString(new Lotto().solution(lottos[i], win_nums[i])));
    }
}
