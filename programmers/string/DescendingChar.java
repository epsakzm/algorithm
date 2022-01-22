package programmers.string;

import java.util.*;
import java.util.stream.Collectors;

public class DescendingChar {
    public String solution(String s) {
        return Arrays.stream(s.split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining());
    }
}
