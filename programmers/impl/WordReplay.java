package programmers.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordReplay {
    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        String before = words[0];
        wordSet.add(words[0]);
        for (int i = 1; i < words.length; ++i) {
            if ((before.charAt(before.length() - 1) != words[i].charAt(0)) || wordSet.contains(words[i]))
                return new int[] { i % n + 1, i / n + 1 };
            before = words[i];
            wordSet.add(words[i]);
        }
        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {
        int[] n = { 3, 5, 2 };
        String[][] words = {
                { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" },
                { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish",
                        "hang", "gather", "refer", "reference", "estimate", "executive" },
                { "hello", "one", "even", "never", "now", "world", "draw" } };
        System.out.println(Arrays.toString(new WordReplay().solution(n[0], words[0])));
        System.out.println(Arrays.toString(new WordReplay().solution(n[1], words[1])));
        System.out.println(Arrays.toString(new WordReplay().solution(n[2], words[2])));
    }
}
