package programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/1844
public class GameMap {
    class Pair {
        int x;
        int y;
        int count;

        Pair(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.count = c;
        }
    }

    public int solution(int[][] maps) {
        final int n = maps.length, m = maps[0].length;
        final int[] dx = { 1, -1, 0, 0 };
        final int[] dy = { 0, 0, -1, 1 };
        boolean visited[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 1));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if (nx == n - 1 && ny == m - 1)
                    return p.count + 1;
                if (nx >= n || ny >= m || nx < 0 || ny < 0)
                    continue;
                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    q.offer(new Pair(nx, ny, p.count + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][][] maps = {
                {
                        { 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1 },
                        { 1, 1, 1, 0, 1 },
                        { 0, 0, 0, 0, 1 }
                },
                {
                        { 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1 },
                        { 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1 }
                }
        };
        System.out.println(new GameMap().solution(maps[0]));
        System.out.println(new GameMap().solution(maps[1]));
    }
}
