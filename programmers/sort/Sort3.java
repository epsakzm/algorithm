package programmers.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class Sort3 {

    public int solution(int[] citations) {
        AtomicInteger h = new AtomicInteger();
        Arrays.stream(citations)
                .boxed()
                .sorted(Collections.reverseOrder())
                .filter(i -> i <= h.getAndIncrement())
                .findFirst();
        return h.get() > 1 ? h.get() - 1 : 0;
    }

    // 6 5 3 1 0
    // 0 1 3 5 6
    public static void main(String[] args) {
        int[] citations = { 5, 5, 5, 5, 5 };
        // int[] citations = { 3, 0, 6, 1, 5 };
        System.out.println(new Sort3().solution(citations));
    }
}
