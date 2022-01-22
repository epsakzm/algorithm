package programmers.impl;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12931
public class NumberBaseAdd {
    public int solution(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
    }

    public static void main(String[] args) {

    }
}
