package programmers.math;

// https://programmers.co.kr/learn/courses/30/lessons/68935
public class Base3 {
    public int solution(int n) {
        String base3 = new StringBuilder(Integer.toString(n, 3)).reverse().toString().replaceAll("0+$", "");
        int answer = base3.charAt(0) - '0';
        for (int i = 1; i < base3.length(); ++i)
            answer = answer * 3 + base3.charAt(i) - '0';
        return answer;
    }
}
