package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/42587
public class Printer {
    // priorities = [1, 1, 9, 1, 1, 1]
    // location = 0
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        // q = [9, 1, 1, 1, 1, 1]
        for (int i : priorities)
            q.offer(i);

        while (!q.isEmpty())
            for (int i = 0; i < priorities.length; ++i)
                if (priorities[i] == q.peek()) {
                    ++answer;
                    if (i == location)
                        return answer;
                    q.poll();
                }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Printer().solution(new int[] { 1, 9, 9, 1, 1, 1 }, 5));
    }
}
