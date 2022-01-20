package Baekjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<>();

        int N = in.nextInt();
        in.close();
        for (int i = 1; i <= N; i++)
            q.offer(i);

        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll()); // 마지막으로 남은 원소 출력
    }
}
