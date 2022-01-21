package programmers;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/67256
public class Keypad {
    class Pad {
        int num;
        int x;
        int y;

        Pad(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        int distance(Pad pad) {
            return Math.abs(this.x - pad.x) + Math.abs(this.y - pad.y);
        }

        void update(Pad pad) {
            this.x = pad.x;
            this.y = pad.y;
        }
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        List<Pad> pads = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                pads.add(new Pad(++num, i, j));
        pads.add(new Pad(0, 3, 1));

        Pad left = new Pad(-1, 3, 0);
        Pad right = new Pad(-1, 3, 2);
        for (int number : numbers) {
            Pad pad = find(pads, number);
            boolean isLeft = true;

            if (number % 3 == 2 || number == 0) {
                int ld = left.distance(pad);
                int rd = right.distance(pad);
                if (ld > rd)
                    isLeft = false;
                else if (ld == rd)
                    isLeft = hand.equals("left");
            } else if (number % 3 == 0)
                isLeft = false;
            sb.append(isLeft ? "L" : "R");
            if (isLeft)
                left.update(pad);
            else
                right.update(pad);
        }
        return sb.toString();
    }

    private Pad find(List<Pad> pads, int number) {
        return pads.stream().filter(p -> p.num == number).findFirst().get();
    }

    public static void main(String[] args) {
        int[][] numbers = {
                { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 },
                { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }
        };
        String[] hand = { "right", "left", "right" };
        for (int i = 0; i < 3; ++i)
            System.out.println(new Keypad().solution(numbers[i], hand[i]));
    }
}
