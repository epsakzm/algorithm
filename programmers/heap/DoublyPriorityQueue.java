package programmers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DoublyPriorityQueue {
    public int[] solution(String[] operations) {
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQueue = new PriorityQueue<>();

        for (String operation : operations) {
            String[] op = operation.split(" ");
            String c = op[0];
            int number = Integer.parseInt(op[1]);

            if (c.equals("I")) {
                maxQueue.offer(number);
                minQueue.offer(number);
            }
            if (c.equals("D")) {
                if (maxQueue.isEmpty())
                    continue;
                if (number == -1) {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
                if (number == 1) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                }
            }
        }
        return maxQueue.isEmpty() ? new int[] { 0, 0 } : new int[] { maxQueue.peek(), minQueue.peek() };
    }

    public static void main(String[] args) {
        String[][] operations = { { "I 16", "D 1" }, { "I 7", "I 5", "I -5", "D -1" },
                { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" } };
        Queue<Integer> q = new PriorityQueue<>();
        System.out.println(q.poll());

        for (String[] operation : operations) {
            System.out.println(Arrays.toString(new DoublyPriorityQueue().solution(operation)));
            System.out.println("=================================================");
        }
    }
}
