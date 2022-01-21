package programmers.math;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/86051
public class NumberAdd {
    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}
