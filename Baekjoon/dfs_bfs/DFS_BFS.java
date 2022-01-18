package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_BFS {
    static int N, M, start;
    static boolean[][] connected;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        start = Integer.parseInt(line[2]);
        connected = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; ++i) {
            String[] nums = br.readLine().split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            connected[num1][num2] = true;
            connected[num2][num1] = true;
        }
    }

    private static void solve() throws IOException {
        dfs(start);
        Arrays.fill(visited, false);
        bw.write("\n");
        bfs();
        bw.flush();
        bw.close();
    }

    private static void dfs(int next) throws IOException {
        bw.write(next + " ");
        visited[next] = true;

        for (int i = 1; i <= N; ++i)
            if (!visited[i] && connected[next][i])
                dfs(i);
    }

    private static void bfs() throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        bw.write(start + " ");

        while (!q.isEmpty()) {
            int next = q.poll();
            for (int i = 1; i <= N; ++i)
                if (!visited[i] && connected[next][i]) {
                    visited[i] = true;
                    q.offer(i);
                    bw.write(i + " ");
                }
        }
    }

    public static void main(String[] args) throws IOException {
        read();
        solve();
    }
}
