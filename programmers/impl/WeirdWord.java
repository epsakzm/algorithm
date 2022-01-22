package programmers.impl;

import java.util.Arrays;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/12930
public class WeirdWord {
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            String[] chs = word.split("");
            for (int j = 0; j < chs.length; ++j)
                sb.append(j % 2 == 0 ? chs[j].toUpperCase() : chs[j].toLowerCase());
            words[i] = sb.toString();
        }
        return Arrays.stream(words).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println("[" + new WeirdWord().solution(s) + "]");
    }
}
