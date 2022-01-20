package Baekjoon.step;

import java.util.Scanner;

public class b2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next().replaceAll("(c=)|(c-)|(dz=)|(d-)|(lj)|(nj)|(s=)|(z=)", "1").length());
        sc.close();
    }
}
