package programmers.impl;

public class Watermelon {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] subak = { "수", "박" };
        for (int i = 0; i < n; ++i)
            sb.append(subak[i % 2]);
        return sb.toString();
    }
}
