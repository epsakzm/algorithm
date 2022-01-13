package programmers.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sort2 {

    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining())
                .replaceAll("^0+", "")
                .replaceAll("^$", "0");
    }

    public static void main(String[] args) {
        int[][] numbers = { { 6, 10, 2 }, { 23, 232, 21, 212 }, { 1000, 100 }, { 3, 30, 34, 5, 9 } };
        String[] answer = { "6210", "2323221221", "1001000", "9534330" };
        for (int i = 0; i < numbers.length; ++i) {
            System.out.println(new Sort2().solution(numbers[i]).equals(answer[i]));
        }
        String[] string = new String[] { "1000", "100", "10" };
        Arrays.sort(string, (s1, s2) -> s2.compareTo(s1));
        System.out.println(Arrays.toString(string));
    }

    /* 메모리 초과 */
    // List<String> answer = new ArrayList<>();
    // boolean[] visited;

    // private void dfs(List<String> list, int depth, StringBuilder sb) {
    // if (depth == list.size()) {
    // answer.add(sb.toString());
    // return;
    // }
    // for (int i = 0; i < list.size(); ++i) {
    // if (visited[i])
    // continue;
    // visited[i] = true;
    // dfs(list, depth + 1, sb.append(list.get(i)));
    // visited[i] = false;
    // sb.setLength(sb.length() - list.get(i).length());
    // }
    // }

    // public String solution(int[] numbers) {
    // visited = new boolean[numbers.length];
    // List<String> list =
    // Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());

    // dfs(list, 0, new StringBuilder());
    // return
    // String.valueOf(answer.stream().mapToInt(Integer::parseInt).max().getAsInt());
    // }
}
