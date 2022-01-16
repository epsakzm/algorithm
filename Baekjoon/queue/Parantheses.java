package Baekjoon.queue;

import java.util.Scanner;

public class Parantheses {
    static void solve() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            String line = sc.next();
            sb.append(solution(line) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }

    static boolean solution(String s) {
        int q = 0;
        for (char c : s.toCharArray())
            if (c == ')') {
                if (q == 0)
                    return false;
                --q;
            } else
                ++q;
        return q == 0;
    }

    public static void main(String[] args) {
        solve();
    }
}
