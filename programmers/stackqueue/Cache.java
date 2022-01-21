package programmers.stackqueue;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/17680
public class Cache {

    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int answer = 0;
        if (cacheSize == 0)
            return cities.length * 5;
        for (String city : cities) {
            city = city.toLowerCase();
            if (q.contains(city)) {
                answer += 1;
                q.remove(city);
            } else {
                answer += 5;
                if (q.size() == cacheSize)
                    q.poll();
            }
            q.offer(city);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] cacheSize = { 3, 3, 2, 5, 2, 0 };
        String[][] cities = {
                { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" },
                { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" },
                { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
                        "NewYork", "Rome" },
                { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
                        "NewYork", "Rome" },
                { "Jeju", "Pangyo", "NewYork", "newyork" },
                { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" }
        };
        for (int i = 0; i < 6; ++i)
            System.out.println(new Cache().solution(cacheSize[i], cities[i]));
    }
}
