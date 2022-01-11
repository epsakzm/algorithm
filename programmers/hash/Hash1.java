package programmers.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/42576
public class Hash1 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant)
            map.put(p, map.getOrDefault(p, 0) + 1);
        for (String c : completion)
            map.put(c, map.get(c) - 1);
        return map.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    // pq풀이
    public String solution2(String[] participant, String[] completion) {
        PriorityQueue<String> q1 = new PriorityQueue<>();
        PriorityQueue<String> q2 = new PriorityQueue<>();
        for (int i = 0; i < participant.length; ++i) {
            q1.offer(participant[i]);
            if (i < participant.length - 1)
                q2.offer(completion[i]);
        }
        for (int i = 0; i < participant.length; ++i) {
            String p = q1.poll();
            String c = q2.poll();
            if (p.equals(c))
                continue;
            return p;
        }
        return null;
    }

    // kiki leo eden
    // kiki eden

    public static void main(String[] args) {
        String[] participant = { "leo", "kiki", "eden" };
        // String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
        // String[] participant = { "mislav", "stanko", "mislav", "ana" };

        String[] completion = { "eden", "kiki" };
        // String[] completion = { "josipa", "filipa", "marina", "nikola" };
        // String[] completion = { "stanko", "ana", "mislav" };
        System.out.println(new Hash1().solution(participant, completion));
    }
}
