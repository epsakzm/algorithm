package programmers;

import java.util.PriorityQueue;

public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i : scoville)
            q.offer(i);

        while (q.peek() < K) {
            int first = q.poll();
            if (q.isEmpty())
                return -1;
            int second = q.poll();

            q.offer(first + second * 2);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        System.out.println(new Scoville().solution(scoville, 7));
    }
}
