package programmers.impl;

// programmers -> 김서방찾기
public class Kim {
    public String solution(String[] seoul) {
        int idx = 0;
        for (int i = 0; i < seoul.length; ++i)
            if (seoul[i].equals("Kim")) {
                idx = i;
                break;
            }
        return String.format("김서방은 %d에 있다", idx);
    }
}
