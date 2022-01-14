package programmers.bruteforce;

import java.util.*;

public class BF2 {
    int answer = 0;
    String[] number;
    boolean[] visited;
    Set<Integer> list = new HashSet<>();

    void dfs(String before) {
        if (!before.equals("") && isPrime(Integer.parseInt(before))) {
            list.add(Integer.parseInt(before));
        }

        for (int i = 0; i < number.length; ++i) {
            if (visited[i])
                continue;
            visited[i] = true;
            dfs(before + number[i]);
            visited[i] = false;
        }
    }

    boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i < num; ++i)
            if (num % i == 0)
                return false;
        return true;
    }

    public int solution(String numbers) {
        number = numbers.split("");
        visited = new boolean[number.length];
        dfs("");
        return list.size();
    }

    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(new BF2().solution(numbers));
    }
}
