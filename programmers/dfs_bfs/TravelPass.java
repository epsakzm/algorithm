package programmers.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/43164
public class TravelPass {

    List<String> answerList = new ArrayList<>();
    boolean[] used;

    private void dfs(int depth, String before, String text, String[][] tickets) {
        if (depth == tickets.length) {
            answerList.add(text);
            return;
        }
        for (int i = 0; i < tickets.length; ++i) {
            if (used[i])
                continue;
            if (before.equals(tickets[i][0])) {
                String to = tickets[i][1];
                used[i] = true;
                dfs(depth + 1, to, text + " " + to, tickets);
                used[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];

        for (int i = 0; i < tickets.length; ++i)
            if (tickets[i][0].equals("ICN"))
                dfs(0, tickets[i][0], tickets[i][0], tickets);
        System.out.println(answerList);
        return answerList.stream().sorted().findFirst().get().split(" ");
    }

    public static void main(String[] args) {
        String[][] tickets = {
                { "ICN", "SFO" },
                { "ICN", "ATL" },
                { "SFO", "ATL" },
                { "ATL", "ICN" },
                { "ATL", "SFO" }
        };
        System.out.println(Arrays.toString(new TravelPass().solution(tickets)));
    }
}
