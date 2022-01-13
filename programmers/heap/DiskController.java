package programmers.heap;

import java.util.*;
import java.util.stream.Collectors;

public class DiskController {

    class Job {
        int requestTime;
        int workingTime;

        Job(int r, int w) {
            this.requestTime = r;
            this.workingTime = w;
        }

        @Override
        public String toString() {
            return this.requestTime + " " + this.workingTime;
        }
    }

    public int solution(int[][] jobs) {
        // 요청 시간 기준으로 빠른 순서대로 job 정렬
        Queue<Job> waiting = new LinkedList<>();
        Arrays.sort(jobs, (job1, job2) -> job1[0] == job2[0] ? job1[1] - job2[1] : job1[0] - job2[0]);
        for (int[] job : jobs)
            waiting.offer(new Job(job[0], job[1]));

        // 실행 중인 큐, 작업시간 짧은게 먼저
        Queue<Job> q = new PriorityQueue<>((job1, job2) -> job1.workingTime - job2.workingTime);

        List<Integer> workingTimeList = new ArrayList<>();

        // 첫 요청 시간은 첫 작업의 시작 시간
        int time = waiting.peek().requestTime;
        int jobCount = 0;

        while (jobCount < jobs.length) {
            while (!waiting.isEmpty() && waiting.peek().requestTime <= time)
                q.offer(waiting.poll());

            if (!q.isEmpty()) {
                Job job = q.poll();
                time += job.workingTime;
                workingTimeList.add(time - job.requestTime);
                ++jobCount;
            } else
                ++time;
        }
        return workingTimeList.stream().collect(Collectors.averagingInt(Integer::valueOf)).intValue();
    }

    public static void main(String[] args) {
        // int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
        int[][] jobs = { { 24, 10 }, { 28, 39 }, { 43, 20 }, { 37, 5 }, { 47, 22 }, { 20, 47 }, { 15, 34 }, { 15, 2 },
                { 35, 43 }, { 26, 1 } };// 72
        Arrays.sort(jobs, (job1, job2) -> job1[0] == job2[0] ? job1[1] - job2[1] : job1[0] - job2[0]);
        for (int[] job : jobs) {
            System.out.println(Arrays.toString(job));
        }

        // int[][] jobs = { { 0, 3 }, { 0, 2 }, { 1, 9 }, { 2, 6 } };
        // System.out.println(new DiskController().solution(jobs));
    }
}
