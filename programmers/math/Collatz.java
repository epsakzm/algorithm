package programmers.math;

// https://programmers.co.kr/learn/courses/30/lessons/12943
public class Collatz {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        for (int i = 1; i <= 500; ++i) {
            if (n % 2 == 0)
                n /= 2;
            else
                n = n * 3 + 1;
            if (n == 1) {
                answer = i;
                break;
            }
        }
        return n == 1 ? num == 1 ? 0 : answer : -1;
    }
}
