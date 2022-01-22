package programmers.math;

import java.util.stream.LongStream;

//https://programmers.co.kr/learn/courses/30/lessons/12912
public class BetweenTwoIntegerSum {

    public long solution(int a, int b) {
        return LongStream.rangeClosed(Math.min(a, b), Math.max(a, b)).sum();
    }

    public static void main(String[] args) {
        System.out.println(new BetweenTwoIntegerSum().solution(0, 0));
    }
}
