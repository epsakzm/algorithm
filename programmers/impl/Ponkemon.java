package programmers.impl;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/1845
public class Ponkemon {
    public int solution(int[] nums) {
        int n1 = nums.length / 2;
        int n2 = (int) Arrays.stream(nums).distinct().count();
        return n1 < n2 ? n1 : n2;
    }
}
