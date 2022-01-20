package Baekjoon.step;

import java.util.Arrays;
import java.util.Scanner;

public class b1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            max = Integer.max(max, arr[i]);
        }
        sc.close();
        System.out.println(Arrays.stream(arr).mapToDouble(i -> i).average().getAsDouble() / max * 100);
    }
}
