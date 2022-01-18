package programmers.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2468 {

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int n;
    static int[][] map;
    static boolean[][] visited;

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            int idx = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                map[i][idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }
        br.close();
    }

    private static void dfs(int x, int y, int height) {
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= n || ny >= n || nx < 0 || ny < 0)
                continue;
            if (!visited[nx][ny] && map[nx][ny] > height) {
                visited[nx][ny] = true;
                dfs(nx, ny, height);
            }
        }
    }

    private static void solve() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 1;
        for (int height = 1; height <= 100; ++height) {
            int count = 0;
            for (int i = 0; i < n; ++i)
                Arrays.fill(visited[i], false);
            for (int r = 0; r < n; ++r)
                for (int c = 0; c < n; ++c)
                    if (!visited[r][c] && map[r][c] > height) {
                        visited[r][c] = true;
                        count++;
                        dfs(r, c, height);
                    }
            if (count == 0)
                break;
            max = Math.max(max, count);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        read();
        solve();
    }
}
