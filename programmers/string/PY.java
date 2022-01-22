package programmers.string;

// https://programmers.co.kr/learn/courses/30/lessons/12916
public class PY {
    boolean solution(String s) {
        return s.replaceAll("[pP]", "").length() == s.replaceAll("[Yy]", "").length();
    }
}
