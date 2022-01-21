package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/1835
public class Photo {
    int answer = 0;
    boolean[] visited = new boolean[8];
    private String[] friends = { "A", "C", "F", "J", "M", "N", "R", "T" }; // 8

    // 2 ["N~F=0", "R~T>2"] 3648
    // 2 ["M~C<2", "C~M>1"] 0
    public int solution(int n, String[] data) {
        dfs("", n, data);
        return answer;
    }

    private void dfs(String line, int n, String[] data) {
        if (line.length() == 8) {
            for (int i = 0; i < n; ++i)
                if (!check(line, data[i]))
                    return;
            ++answer;
        }
        for (int i = 0; i < 8; ++i)
            if (!visited[i]) {
                visited[i] = true;
                dfs(line + friends[i], n, data);
                visited[i] = false;
            }
    }

    // a랑 e랑 3칸이상떨어지고싶음 dist A~E>3 dist = 4 need = 4
    // a b c d e
    private boolean check(String line, String data) {
        int dist = Math.abs(line.indexOf(data.charAt(0)) - line.indexOf(data.charAt(2)));
        char op = data.charAt(3);
        int need = data.charAt(4) - 48 + 1;

        if (op == '=' && dist == need)
            return true;
        else if (op == '>' && dist > need)
            return true;
        else if (op == '<' && dist < need)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Photo().solution(2, new String[] { "N~F=0", "R~T>2" }));
    }
}