package programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/43162
public class Network {
    boolean[] visited;

    private void dfs(int com, int n, int[][] computers) {
        visited[com] = true;
        for (int i = 0; i < n; ++i)
            if (computers[com][i] == 1 && !visited[i])
                dfs(i, n, computers);
    }

    private void bfs(int com, int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(com);
        visited[com] = true;
        while (!queue.isEmpty()) {
            int next = queue.poll();

            for (int i = 0; i < n; ++i)
                if (!visited[i] && computers[next][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        // dfs
        // for (int com = 0; com < n; ++com)
        // if (!visited[com]) {
        // answer++;
        // dfs(com, n, computers);
        // }
        // dfs end
        // bfs
        for (int com = 0; com < n; ++com) {
            if (!visited[com]) {
                answer++;
                bfs(com, n, computers);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][][] computers = {
                {
                        { 1, 1, 0 },
                        { 1, 1, 0 },
                        { 0, 0, 1 }
                },
                {
                        { 1, 1, 0 },
                        { 1, 1, 1 },
                        { 0, 1, 1 }
                }
        };
        System.out.println(new Network().solution(n, computers[0]));
        System.out.println(new Network().solution(n, computers[1]));
    }
}
