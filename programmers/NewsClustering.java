package programmers;

import java.util.*;

public class NewsClustering {
    List<Map<String, Integer>> count = new ArrayList<>();
    List<Set<String>> words = new ArrayList<>();
    Set<String> dupWords = new HashSet<>();
    int totalCnt = 0;

    private void addParsedData(List<String> list, int idx) {
        String str = list.get(idx);
        for (int i = 0; i < str.length() - 1; ++i) {
            String sub = str.substring(i, i + 2);
            if (!sub.matches("^[a-z][a-z]$"))
                continue;
            words.get(idx).add(sub);
            int newCnt = count.get(idx).getOrDefault(sub, 0) + 1;

            count.get(idx).put(sub, newCnt);

            if (count.get(idx == 1 ? 0 : 1).getOrDefault(sub, 0) != 0)
                dupWords.add(sub);
        }
    }

    public int solution(String str1, String str2) {
        int dupCnt = 0;
        List<String> list = List.of(str1.toLowerCase(), str2.toLowerCase());
        for (int i = 0; i < 2; ++i) {
            count.add(new HashMap<>());
            words.add(new HashSet<>());
        }
        for (int i = 0; i < 2; ++i)
            addParsedData(list, i);

        for (int i = 0; i < 2; ++i) {

        }

        for (String dupWord : dupWords) {
            int cnt1 = count.get(0).get(dupWord);
            int cnt2 = count.get(1).get(dupWord);

            int max = Math.max(cnt1, cnt2);
            int min = Math.min(cnt1, cnt2);

            // totalCnt += max;
            dupCnt += min;
        }

        // System.out.println("total*******");
        // total.forEach(System.out::println);

        // System.out.println("dup*********");
        // dup.forEach(System.out::println);
        System.out.println(count.toString());
        System.out.println(dupCnt + " / " + totalCnt);
        return (int) (((double) dupCnt / totalCnt) * 65536);
    }

    public static void main(String[] args) {
        // 16384
        // System.out.println(new NewsClustering().solution("FRANCE", "french"));
        // 43690 2/3
        // System.out.println(new NewsClustering().solution("aa1+aa2", "AAAA12"));
        // 65536
        // System.out.println(new NewsClustering().solution("E=M*C^2", "e=m*c^2"));
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.remove("4"));
    }
}
