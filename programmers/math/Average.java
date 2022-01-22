package programmers.math;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12944
public class Average {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
