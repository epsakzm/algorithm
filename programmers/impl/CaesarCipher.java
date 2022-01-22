package programmers.impl;

// https://programmers.co.kr/learn/courses/30/lessons/12926
public class CaesarCipher {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            sb.append(Character.isLowerCase(ch) ? (char) ((ch - 'a' + n) % 26 + 'a')
                    : Character.isWhitespace(ch) ? " " : (char) ((ch - 'A' + n) % 26 + 'A'));
        }
        return sb.toString();
    }
}
