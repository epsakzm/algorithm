package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/77884
public class Divisor {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; ++i)
            answer = answer + (isDivisorCountEven(i) ? i : -i);
        return answer;
    }

    private boolean isDivisorCountEven(int number) {
        int count = 0;
        for (int i = 1; i <= number; ++i)
            if (number % i == 0)
                count++;
        return count % 2 == 0;
    }
}
