package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Hash4 {

    class Music implements Comparable<Music> {
        int id;
        int play;

        Music(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public String toString() {
            return "id: " + id + " play: " + play;
        }

        @Override
        public int compareTo(Music music) {
            if (music.play == this.play)
                return this.id > music.id ? 1 : -1;
            return music.play > this.play ? 1 : -1;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new LinkedList<>();
        Map<String, PriorityQueue<Music>> map = new HashMap<>();
        Map<String, Integer> playTimes = new HashMap<>();

        for (int i = 0; i < genres.length; ++i) {
            if (map.containsKey(genres[i])) {
                map.get(genres[i]).add(new Music(i, plays[i]));
                playTimes.put(genres[i], playTimes.get(genres[i]) + plays[i]);
            } else {
                PriorityQueue<Music> list = new PriorityQueue<>();
                list.add(new Music(i, plays[i]));
                map.put(genres[i], list);
                playTimes.put(genres[i], plays[i]);
            }
        }

        List<String> topList = extract(playTimes);
        for (int i = 0; i < topList.size(); ++i) {
            String genre = topList.get(i);
            PriorityQueue<Music> mQueue = map.get(genre);
            for (int idx = 0; idx < 2 && !mQueue.isEmpty(); ++idx)
                answer.add(mQueue.poll().id);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<String> extract(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> e1.getValue() < e2.getValue() ? 1 : -1);

        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i)
            newList.add(list.get(i).getKey());

        return newList;
    }

    public static void main(String[] args) {

    }
}