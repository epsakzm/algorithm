package Baekjoon.bruteforce;

import java.util.*;

//https://www.acmicpc.net/problem/15686
public class B15686 {
    static List<Pair> chickens = new ArrayList<>();
    static List<Pair> houses = new ArrayList<>();
    static List<Set<Pair>> pairs = new ArrayList<>();
    static boolean[] visited;
    static int n;
    static int m;

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "[" + this.x + ", " + this.y + "]";
        }

        @Override
        public boolean equals(Object o) {
            return this.x == ((Pair) o).x && this.y == ((Pair) o).y;
        }
    }

    /////////////////////////// 하는중
    static void dfs(List<Pair> list, int depth) {
        if (depth == m) {
            pairs.add(new HashSet<>(list));
            return;
        }
        for (int i = 0; i < chickens.size(); ++i) {
            Pair pair = chickens.get(i);
            if (visited[i] || list.contains(pair))
                continue;
            visited[i] = true;
            list.add(pair);
            dfs(list, depth + 1);
            list.remove(pair);
            visited[i] = false;
        }
    }

    private static void read() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                int num = sc.nextInt();
                if (num == 1)
                    houses.add(new Pair(i, j));
                if (num == 2)
                    chickens.add(new Pair(i, j));
            }
        sc.close();
        visited = new boolean[chickens.size()];
    }

    private static void solve() {
        System.out.println("Chickens");
        System.out.println(chickens);
        System.out.println("Houses");
        System.out.println(houses);
        System.out.println("dfs");
        dfs(new ArrayList<Pair>(), 0);
        System.out.println(pairs);
    }

    // 0: 빈칸 1: 집 2: 치킨집
    public static void main(String[] args) {
        read();
        solve();
    }

    // 5 3
    String[] tc = {
            "5 3 0 0 1 0 0 0 0 2 0 1 0 1 2 0 0 0 0 1 0 0 0 0 0 0 2", // 5
            "5 2 0 2 0 1 0 1 0 1 0 0 0 0 0 0 0 2 0 0 1 1 2 2 0 1 2", // 10
            "5 1 1 2 0 0 0 1 2 0 0 0 1 2 0 0 0 1 2 0 0 0 1 2 0 0 0", // 11
            "5 1 1 2 0 2 1 1 2 0 2 1 1 2 0 2 1 1 2 0 2 1 1 2 0 2 1" // 32
    };

}
