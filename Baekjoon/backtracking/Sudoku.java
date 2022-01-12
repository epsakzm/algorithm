package Baekjoon.backtracking;

import java.util.Scanner;

public class Sudoku {

    static StringBuilder sb = new StringBuilder();
    static int[][] map = new int[9][9];
    static Pair[] pairs = new Pair[81];
    static int len = 0;

    private static void dfs(int depth) {
        if (depth == len) {
            for (int[] x : map) {
                for (int y : x)
                    sb.append(y).append(" ");
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        int x = pairs[depth].x;
        int y = pairs[depth].y;

        for (int num = 1; num <= 9; ++num)
            if (check(x, y, num)) {
                map[x][y] = num;
                dfs(depth + 1);
                map[x][y] = 0;
            }
    }

    private static boolean check(int r, int c, int target) {
        // 행열 체크
        for (int idx = 0; idx < 9; ++idx) {
            if (map[r][idx] == target)
                return false;
            if (map[idx][c] == target)
                return false;
        }

        // 3x3 체크
        int startR = r / 3 * 3;
        int startC = c / 3 * 3;

        for (int i = startR; i < startR + 3; i++)
            for (int j = startC; j < startC + 3; j++)
                if (map[i][j] == target)
                    return false;

        return true;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        read();
        dfs(0);
    }

    private static void read() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0)
                    pairs[len++] = new Pair(i, j);
            }
        sc.close();
    }


}
