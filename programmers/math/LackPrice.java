package programmers.math;

// https://programmers.co.kr/learn/courses/30/lessons/82612
public class LackPrice {

    public long solution(int price, int money, int count) {
        long answer = 0;
        int cnt = 0;
        while (++cnt <= count)
            answer += price * cnt;
        return money > answer ? 0 : answer - money;
    }

    public static void main(String[] args) {
        // 10
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(new LackPrice().solution(price, money, count));
    }
}
