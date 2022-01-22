package programmers.impl;

import java.util.LinkedList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/12906
public class HateSameDigit {

    public int[] solution(int[] arr) {
        List<Integer> list = new LinkedList<>();
        int idx = 0;
        while (idx < arr.length) {
            int i = arr[idx];
            list.add(i);
            while (++idx < arr.length && i == arr[idx])
                ;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }
}
