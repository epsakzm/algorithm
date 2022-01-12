package Baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2178 {

    static int[][] map;
    static int[][] distance;
    static int r;
    static int c;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void run() {
        Queue<Point> q = new LinkedList<>();
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        q.offer(new Point(0, 0));
        distance[0][0] = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if (nx >= r || ny >= c || nx < 0 || ny < 0)
                    continue;
                if (distance[nx][ny] == 0 && map[nx][ny] == 1) {
                    distance[nx][ny] = distance[p.x][p.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        read();
        run();
        System.out.println(distance[r - 1][c - 1]);
    }

    static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().split(" ");
        r = Integer.parseInt(number[0]);
        c = Integer.parseInt(number[1]);
        map = new int[r][c];
        distance = new int[r][c];

        for (int i = 0; i < r; ++i) {
            String line = br.readLine();
            String[] chars = line.split("");
            for (int j = 0; j < c; ++j) {
                map[i][j] = Integer.parseInt(chars[j]);
            }
        }
    }
}
