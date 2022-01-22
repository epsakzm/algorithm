package programmers.impl;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12932
public class ReverseInteger {
    public int[] solution(long n) {
        return Arrays.stream(new StringBuilder(String.valueOf(n)).reverse().toString().split(""))
                .mapToInt(Integer::parseInt).toArray();
    }
}
