package programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/64065
public class Tuple {

    public int[] solution(String s) {
        int[] cnt = new int[1000001];
        return Arrays.stream(s.split("^(\\{\\{)|(\\},\\{)|(\\}\\})$"))
                .map(st -> st.split(","))
                .flatMap(Arrays::stream)
                .filter(st -> !st.equals(""))
                .map(Integer::parseInt)
                .peek(i -> {
                    cnt[i]++;
                })
                .distinct()
                .sorted((a, b) -> cnt[b] - cnt[a])
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    // 다른사람풀이1
    public int[] solution2(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });
        int[] answer = new int[arr.length];
        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2))
                    answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

    // 다른사람풀이 2
    public int[] solution3(String s) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(s.replaceAll("\\{", "").replaceAll("\\}", "").split(","))
                .forEach(v -> {
                    map.put(v, map.getOrDefault(v, 0) + 1);
                });

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int[] answer = list.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Tuple().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(new Tuple().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(new Tuple().solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(new Tuple().solution("{{123}}")));
        System.out.println(Arrays.toString(new Tuple().solution3("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
