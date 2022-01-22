package programmers.math;

import java.util.stream.LongStream;

// https://programmers.co.kr/learn/courses/30/lessons/12954
public class XN {
    public long[] solution(int x, int n) {
        return LongStream.rangeClosed(1, n).map(l -> l * x).toArray();
    }
}
