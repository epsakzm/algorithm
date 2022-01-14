package programmers.bruteforce;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/42842
public class BF3 {

    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= total; ++i)
            if (total % i == 0)
                list.add(i);

        for (int i = 0; i < list.size(); ++i) {
            int height = list.get(i);
            int width = list.get(list.size() - 1 - i);
            if (height * width == total && ((height - 2) * (width - 2) == yellow))
                return new int[] { width, height };
        }

        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        System.out.println(Arrays.toString(new BF3().solution(brown, yellow)));
    }
    // dfs 시간초과
    // int num;
    // Set<Integer> set = new TreeSet<>();
    // public void dfs(int before, int depth, int total) {
    // if (depth == 2) {
    // if (before == total) {
    // set.add(num);
    // set.add(total / num);
    // }
    // return;
    // }
    // for (int i = 1; i <= total; ++i) {
    // num = i;
    // dfs(before * i, depth + 1, total);
    // }
    // }
}
