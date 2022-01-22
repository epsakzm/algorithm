package programmers.math;

import java.util.Arrays;

public class DivisorElement {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
        return answer.length == 0 ? new int[] { -1 } : answer;
    }

    public static void main(String[] args) {

    }
}
