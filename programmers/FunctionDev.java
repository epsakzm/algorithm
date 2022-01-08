package programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42586
public class FunctionDev {

    // 내풀이
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int last = 0;
        while (last < progresses.length) {
            int times = 1, cnt = 1;
            while ((progresses[last] + speeds[last] * times) < 100)
                ++times;
            for (int i = last; i < progresses.length; ++i)
                progresses[i] += speeds[i] * times;
            for (++last; last < progresses.length && progresses[last] >= 100; ++last)
                ++cnt;
            answer.add(cnt);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // Array
    public int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = 0;
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
    }

    // Queue
    public int[] solution3(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Arrays.stream(new FunctionDev().solution2(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 }))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(new FunctionDev().solution2(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 }))
                .forEach(i -> System.out.print(i + " "));
    }
}
