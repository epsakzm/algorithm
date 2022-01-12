package programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> ready = new LinkedList<>();

        for (int i = 0; i < bridge_length; ++i)
            bridge.offer(0);

        for (int truck : truck_weights)
            ready.offer(truck);

        int time = 0;
        int curWeight = 0;

        while (!ready.isEmpty()) {
            ++time;
            curWeight -= bridge.poll();

            int nextTruck = ready.peek();
            if (curWeight + nextTruck <= weight) {
                curWeight += nextTruck;
                ready.poll();
                bridge.offer(nextTruck);
            } else
                bridge.offer(0);
        }

        return time + bridge_length;
    }
}
