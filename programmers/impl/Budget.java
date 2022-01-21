package programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12982
public class Budget {

    public int solution(int[] d, int budget) {
        int answer = 0;
        int total = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; ++i) {
            total += d[i];
            if (total > budget)
                break;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] d = { 2, 2, 3, 3 };
        // int[] d = { 1, 3, 2, 5, 4 };
        int budget = 10;
        // int budget = 9;
        System.out.println(new Budget().solution(d, budget));
    }
}
