package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRenewal {

    List<Map<String, Integer>> maps = new ArrayList<>();
    int[] maxList = new int[11];

    void comb(int idx, char[] order, StringBuilder builder) {
        if (idx == order.length) {
            int length = builder.length();
            if (length >= 2) {
                int count = maps.get(length).getOrDefault(builder.toString(), 0) + 1;
                maps.get(length).put(builder.toString(), count);
                maxList[length] = Math.max(maxList[length], count);
            }
            return;
        }

        comb(idx + 1, order, builder.append(order[idx]));
        builder.setLength(builder.length() - 1);
        comb(idx + 1, order, builder);
    }

    // orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < 11; ++i)
            maps.add(new HashMap<String, Integer>());

        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            comb(0, orderArray, new StringBuilder());
        }
        // maps.forEach(m -> m.entrySet().forEach(e -> System.out.println(e.getKey() + "
        // " + e.getValue())));

        List<String> list = new ArrayList<>();
        for (int len : course) {
            maps.get(len).entrySet().stream()
                    .filter(e -> maxList[len] >= 2 && e.getValue() == maxList[len])
                    .map(Map.Entry::getKey)
                    .forEach(list::add);
        }
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        int[] course = { 2, 3, 4 };
        System.out.println(Arrays.toString(new MenuRenewal().solution(orders, course)));
    }
}

// List<Map<String, Integer>> foodMaps = new ArrayList<>();
// int[] maxCount = new int[11];

// private void comb(char[] order, int idx, StringBuilder candi) {
// if (idx >= order.length) {
// int len = candi.length();
// if (len >= 2) {
// int cnt = foodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
// foodMaps.get(len).put(candi.toString(), cnt);
// maxCount[len] = Math.max(maxCount[len], cnt);
// }
// return;
// }

// comb(order, idx + 1, candi.append(order[idx]));
// candi.setLength(candi.length() - 1);
// comb(order, idx + 1, candi);
// }

// public String[] solution(String[] orders, int[] course) {
// for (int i = 0; i < 11; ++i)
// foodMaps.add(new HashMap<String, Integer>());

// for (String order : orders) {
// char[] arr = order.toCharArray();
// Arrays.sort(arr);
// comb(arr, 0, new StringBuilder());
// }

// List<String> list = new ArrayList<>();

// for (int len : course) {
// foodMaps.get(len).entrySet().stream()
// .filter(e -> e.getValue() >= 2 && e.getValue() == maxCount[len])
// .map(Map.Entry::getKey)
// .forEach(list::add);
// }

// return list.toArray(new String[list.size()]);
// }