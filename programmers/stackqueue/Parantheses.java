package programmers.stackqueue;

public class Parantheses {

    boolean solution(String s) {
        int q = 0;
        for (char c : s.toCharArray())
            if (c == ')') {
                if (q == 0)
                    return false;
                --q;
            } else
                ++q;
        return q == 0;
    }
}