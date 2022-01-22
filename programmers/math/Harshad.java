package programmers.math;

import java.util.Arrays;

// 프로그래멋 - 하샤드수
public class Harshad {
    public boolean solution(int x) {
        int sum = Arrays.stream(String.valueOf(x).split("")).mapToInt(Integer::parseInt).sum();
        return x % sum == 0;
    }
}
