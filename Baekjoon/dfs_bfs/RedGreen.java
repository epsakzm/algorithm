package Baekjoon.dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

// 적록색약
public class RedGreen {
    static char[][] map;
    static boolean[][] visited;
    static int lines;
    static int cnt1 = 0;
    static int cnt2 = 0;

    public static void read() {
        Scanner sc = new Scanner(System.in);
        lines = sc.nextInt();
        map = new char[lines][lines];
        visited = new boolean[lines][lines];
        for (int i = 0; i < lines; ++i) {
            String s = sc.next();
            map[i] = s.toCharArray();
        }
        sc.close();
    }

    private static void run() {
        for (int r = 0; r < lines; ++r)
            for (int c = 0; c < lines; ++c)
                if (!visited[r][c]) {
                    dfs(r, c, map[r][c]);
                    cnt1++;
                }
        for (int i = 0; i < lines; ++i)
            Arrays.fill(visited[i], false);
        for (int r = 0; r < lines; ++r)
            for (int c = 0; c < lines; ++c)
                if (!visited[r][c]) {
                    if (map[r][c] == 'R' || map[r][c] == 'G')
                        dfs(r, c, 'R', 'G');
                    else
                        dfs(r, c, 'B');
                    cnt2++;
                }
    }

    private static void dfs(int r, int c, char... ch) {
        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        visited[r][c] = true;
        for (int i = 0; i < 4; ++i) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= lines || nc >= lines)
                continue;
            if (visited[nr][nc])
                continue;
            if (matches(map[nr][nc], ch)) {
                visited[nr][nc] = true;
                dfs(nr, nc, ch);
            }
        }
    }

    private static boolean matches(char c, char... ch) {
        for (int i = 0; i < ch.length; ++i)
            if (c == ch[i])
                return true;
        return false;
    }

    public static void main(String[] args) {
        read();
        run();
        System.out.println(cnt1 + " " + cnt2);
    }
}
