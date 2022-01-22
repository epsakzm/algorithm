package programmers.math;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/86491
public class MinimumSquare {
    public int solution(int[][] sizes) {
        List<Integer> maxList = new ArrayList<>();
        List<Integer> minList = new ArrayList<>();
        int minMax = 0;
        int maxMax = 0;
        for (int i = 0; i < sizes.length; ++i) {
            int w = sizes[i][0];
            int h = sizes[i][1];

            maxList.add(w > h ? w : h);
            minList.add(w < h ? w : h);
            maxMax = Math.max(maxMax, w);
            maxMax = Math.max(maxMax, h);
        }
        for (int min : minList)
            for (int max : maxList)
                if (min <= max)
                    minMax = Math.max(minMax, min);

        return minMax * maxMax;
    }
}
