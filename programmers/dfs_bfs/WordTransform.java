package programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/43163
public class WordTransform {
    static class Word {
        String text;
        int count;

        Word(String t, int c) {
            this.text = t;
            this.count = c;
        }
    }

    private boolean check(String from, String to) {
        int cnt = 0;
        for (int i = 0; i < from.length(); ++i)
            if (from.charAt(i) != to.charAt(i))
                ++cnt;
        return cnt == 1;
    }

    private int bfs(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        q.offer(new Word(begin, 0));

        while (!q.isEmpty()) {
            Word word = q.poll();

            if (word.text.equals(target))
                return word.count;

            for (int i = 0; i < words.length; ++i)
                if (!visited[i] && check(word.text, words[i])) {
                    q.offer(new Word(words[i], word.count + 1));
                    visited[i] = true;
                }
        }
        return 0;
    }

    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "wow";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog", "wow" };
        // String[] words = { "hot", "dot", "dog", "lot", "log" };
        System.out.println(new WordTransform().solution(begin, target, words));
    }
}
