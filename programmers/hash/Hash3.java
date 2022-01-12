package programmers.hash;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Hash3 {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < clothes.length; ++i) {
            String name = clothes[i][0];
            String type = clothes[i][1];
            if (map.containsKey(type))
                map.get(type).add(name);
            else
                map.put(type, new ArrayList<>() {
                    {
                        add(name);
                    }
                });
        }

        return map.values().stream()
                .map(l -> l.size() + 1)
                .reduce(1, (a, b) -> a * b) - 1;
    }

    //
    public int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }
}
