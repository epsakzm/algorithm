package programmers.greedy;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42884
public class Greedy6 {

    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int position = routes[0][1];
        for (int[] route : routes) {
            if (position < route[0]) {
                answer++;
                position = route[1];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
        System.out.println(new Greedy6().solution(routes));
    }
}
