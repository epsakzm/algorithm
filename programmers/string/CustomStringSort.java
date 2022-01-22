package programmers.string;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12915
public class CustomStringSort {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted((s1, s2) -> s1.charAt(n) == s2.charAt(n) ? s1.compareTo(s2) : s1.charAt(n) - s2.charAt(n))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {

    }
}
