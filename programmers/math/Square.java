package programmers.math;

// https://programmers.co.kr/learn/courses/30/lessons/12934
public class Square {
    public long solution(long n) {
        double sq = Math.sqrt(n);
        if (sq % 1 > 0)
            return -1;
        return (long) (sq + 1) * (long) (sq + 1);
    }
}
