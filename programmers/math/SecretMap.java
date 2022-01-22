package programmers.math;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/17681
public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; ++i)
            answer[i] = binaryOr(arr1[i], arr2[i], n).replaceAll("[1]", "#").replaceAll("[0]", " ");
        return answer;
    }

    private String binaryOr(int a, int b, int n) {
        String binary = Integer.toBinaryString(a | b);
        return "0".repeat(n - binary.length()) + binary;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = { 9, 20, 28, 18, 11 };
        int[] arr2 = { 30, 1, 21, 17, 28 };
        System.out.println(Arrays.toString(new SecretMap().solution(n, arr1, arr2)));
    }
}
