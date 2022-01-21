package programmers.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/68644
public class Pick2Add {

    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int[] solution(int[] numbers) {
        visited = new boolean[numbers.length];
        dfs(0, 0, numbers);
        return set.stream().sorted().mapToInt(i -> i).toArray();
    }

    public void dfs(int depth, int number, int[] numbers) {
        if (depth == 2) {
            set.add(number);
            return;
        }
        for (int i = 0; i < numbers.length; ++i)
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, number + numbers[i], numbers);
                visited[i] = false;
            }
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 1, 3, 4, 1 };
        System.out.println(Arrays.toString(new Pick2Add().solution(numbers)));
    }

    // public int[] solution(int[] numbers) {
    // Set<Integer> set = new HashSet<>();
    // for (int i = 0; i < numbers.length; ++i)
    // for (int j = i + 1; j < numbers.length; ++j)
    // set.add(numbers[i] + numbers[j]);
    // return set.stream().sorted().mapToInt(i -> i).toArray();
    // }
}
