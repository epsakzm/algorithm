package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/1012
public class B1012 {
    static int tc;
    static int c;
    static int r;
    static int k;
    static int[][] map;
    static boolean[][] visited;

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int answer = 0;
            String[] nums = br.readLine().split(" ");
            c = Integer.parseInt(nums[0]);
            r = Integer.parseInt(nums[1]);
            k = Integer.parseInt(nums[2]);
            map = new int[r][c];
            visited = new boolean[r][c];
            for (int i = 0; i < k; ++i) {
                String[] line = br.readLine().split(" ");
                int c = Integer.parseInt(line[0]);
                int r = Integer.parseInt(line[1]);
                map[r][c] = 1;
            }
            for (int i = 0; i < r; ++i)
                for (int j = 0; j < c; ++j)
                    if (map[i][j] == 1 && !visited[i][j]) {
                        ++answer;
                        dfs(i, j);
                    }
            bw.write(answer + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        visited[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c)
                continue;
            if (visited[nx][ny])
                continue;
            if (map[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
