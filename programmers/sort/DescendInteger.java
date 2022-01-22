package programmers.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/12933
public class DescendInteger {
    public long solution(long n) {
        return Long.parseLong(Arrays.stream(String.valueOf(n).split(""))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining()));
    }
}
