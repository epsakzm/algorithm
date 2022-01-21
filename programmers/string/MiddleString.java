package programmers.string;

// https://programmers.co.kr/learn/courses/30/lessons/12903
public class MiddleString {
    public String solution(String s) {
        int from = s.length() % 2 == 0 ? s.length() / 2 - 1 : s.length() / 2;
        int to = s.length() % 2 == 0 ? from + 2 : from + 1;
        return s.substring(from, to);
    }
}
