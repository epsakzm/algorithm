package programmers.impl;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

//https://programmers.co.kr/learn/courses/30/lessons/76501
public class PositiveNegative {
    public int solution(int[] absolutes, boolean[] signs) {
        AtomicInteger i = new AtomicInteger(0);
        return Arrays.stream(absolutes).map(a -> signs[i.getAndIncrement()] ? a : -a).sum();
    }
}
