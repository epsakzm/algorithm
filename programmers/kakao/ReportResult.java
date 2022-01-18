package programmers.kakao;

import java.util.*;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/92334
public class ReportResult {
    Map<String, List<String>> reportMap = new HashMap<>();
    Map<String, Integer> reported = new HashMap<>();
    Map<String, Integer> answer = new HashMap<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ans = new int[id_list.length];
        for (String r : report) {
            String[] sp = r.split(" ");
            String from = sp[0];
            String to = sp[1];

            if (reportMap.containsKey(from)) {
                if (reportMap.get(from).contains(to))
                    continue;
                reportMap.get(from).add(to);
            } else {
                List<String> list = new ArrayList<>();
                list.add(to);
                reportMap.put(from, list);
            }
            reported.put(to, reported.getOrDefault(to, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : reported.entrySet())
            if (entry.getValue() >= k)
                for (Map.Entry<String, List<String>> r : reportMap.entrySet())
                    if (r.getValue().contains(entry.getKey()))
                        answer.put(r.getKey(), answer.getOrDefault(r.getKey(), 0) + 1);
        int idx = 0;
        for (String id : id_list) {
            ans[idx] = answer.getOrDefault(id, 0);
            idx++;
        }
        return ans;
    }

    // Stream
    public int[] solution2(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }

    public static void main(String[] args) {
        String[][] id_list = {
                { "muzi", "frodo", "apeach", "neo" },
                { "con", "ryan" }
        };
        String[][] report = {
                { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" },
                { "ryan con", "ryan con", "ryan con", "ryan con" }
        };
        int[] k = { 2, 3 };
        System.out.println(Arrays.toString(new ReportResult().solution(id_list[0], report[0], k[0])));
        System.out.println(Arrays.toString(new ReportResult().solution(id_list[1], report[1], k[1])));
    }
}
