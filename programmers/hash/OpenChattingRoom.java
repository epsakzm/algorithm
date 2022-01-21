package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/42888
public class OpenChattingRoom {
    public String[] solution(String[] record) {
        ChatCache c = new ChatCache();
        for (String s : record) {
            String[] arr = s.split(" ");
            if (arr[0].equals("Leave")) {
                c.add(new Info(arr[0], arr[1], null));
                continue;
            }
            c.add(new Info(arr[0], arr[1], arr[2]));
        }
        return c.print();
    }

    static class ChatCache {
        List<Info> history = new LinkedList<>();
        Map<String, String> idMap = new HashMap<>();

        void add(Info info) {
            if (!info.getType().equals("Change"))
                history.add(info);
            if (!info.getType().equals("Leave"))
                idMap.put(info.getUid(), info.getNickname());
        }

        String[] print() {
            return history.stream().map(h -> {
                if (h.type.equals("Enter"))
                    return idMap.get(h.getUid()) + "님이 들어왔습니다.";
                else {
                    return idMap.get(h.getUid()) + "님이 나갔습니다.";
                }
            }).collect(Collectors.toList()).toArray(new String[history.size()]);
        }
    }

    static class Info {
        String type;
        String uid;
        String nickname;

        public Info(String type, String uid, String nickname) {
            this.type = type;
            this.uid = uid;
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }

        public String getType() {
            return type;
        }

        public String getUid() {
            return uid;
        }
    }

    public static void main(String[] args) {
        String[] list = Arrays.asList("Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo", "Change uid4567 Ryan").toArray(new String[5]);
        Arrays.stream(new OpenChattingRoom()
                .solution(list)).forEach(System.out::println);
    }
}
