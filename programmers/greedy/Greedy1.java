package programmers.greedy;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42862
public class Greedy1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[31];
        Arrays.fill(student, 1);
        for (int i = 0; i < reserve.length; ++i)
            ++student[reserve[i]];
        for (int i = 0; i < lost.length; ++i)
            --student[lost[i]];
        for (int i = 1; i <= n; ++i)
            if (student[i] == 2)
                if (student[i - 1] == 0) {
                    --student[i];
                    ++student[i - 1];
                } else if (student[i + 1] == 0) {
                    --student[i];
                    ++student[i + 1];
                }
        return (int) Arrays.stream(Arrays.copyOfRange(student, 1, n + 1)).filter(i -> i >= 1).count();
    }

    public static void main(String[] args) {
        int n = 6;
        int[] lost = { 1, 3, 5 };
        // int[] reserve = { 1, 3, 5 };
        int[] reserve = { 2, 4, 6 };
        System.out.println(new Greedy1().solution(n, lost, reserve));
    }
}
