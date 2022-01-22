package programmers.math;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12935
public class RemoveMin {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = Arrays.stream(arr).filter(i -> i > min).toArray();
        return answer.length == 0 ? new int[] { -1 } : answer;
    }
}
