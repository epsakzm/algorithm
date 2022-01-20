package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/11000
public class B11000 {
    static class Lecture implements Comparable<Lecture> {
        int start, end;

        Lecture(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Lecture lecture) {
            return this.start == lecture.start ? this.end - lecture.end : this.start - lecture.start;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; ++i) {
            String[] s = br.readLine().split(" ");
            lectures[i] = new Lecture(Integer.parseInt(s[0]), Integer.parseInt(s[1]) - 1);
        }
        Arrays.sort(lectures);
        pq.offer(lectures[0].end);
        for (int i = 1; i < n; ++i) {
            if (lectures[i].start > pq.peek())
                pq.poll();
            pq.offer(lectures[i].end);
        }
        bw.write(pq.size() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
