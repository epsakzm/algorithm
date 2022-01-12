package Baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class B2565 {
    static int[] dp = new int[101];
    static Line[] lines;
    static int n;

    static class Line {
        int left;
        int right;

        Line(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static void read() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lines = new Line[n + 1];
        for (int i = 1; i <= n; ++i)
            lines[i] = new Line(sc.nextInt(), sc.nextInt());
        sc.close();
    }

    static void run() {
        int answer = 0;
        Arrays.sort(lines, 1, lines.length, (l1, l2) -> l1.left - l2.left);
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j < i; ++j)
                if (lines[i].right > lines[j].right)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(n - answer);
    }

    public static void main(String[] args) {
        read();
        run();
    }
}