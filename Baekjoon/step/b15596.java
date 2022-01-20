package Baekjoon.step;

import java.util.Arrays;

public class b15596 {
    long sum(int[] a) {
        return Arrays.stream(a).mapToLong(Long::valueOf).sum();
    }
}
