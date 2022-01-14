package programmers.bruteforce;

import java.util.Arrays;

public class BF1 {
    static class Supoja {
        static int serial = 0;
        int idx;
        int[] answer;
        int count;

        Supoja(int... answer) {
            this.answer = answer;
            this.count = 0;
            this.idx = ++serial;
        }

        public int getIdx() {
            return this.idx;
        }
    }

    public int[] solution(int[] answers) {
        Supoja[] supojadeul = new Supoja[3];
        supojadeul[0] = new Supoja(1, 2, 3, 4, 5);
        supojadeul[1] = new Supoja(2, 1, 2, 3, 2, 4, 2, 5);
        supojadeul[2] = new Supoja(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        for (int i = 0; i < answers.length; ++i)
            for (int j = 0; j < supojadeul.length; ++j) {
                Supoja supoja = supojadeul[j];
                if (supoja.answer[i % supoja.answer.length] == answers[i])
                    ++supoja.count;
            }

        int temp = -1;
        for (int i = 0; i < supojadeul.length; ++i)
            if (temp < supojadeul[i].count)
                temp = supojadeul[i].count;
        final int max = temp;

        return Arrays.stream(supojadeul)
                .filter(s -> s.count == max)
                .mapToInt(Supoja::getIdx)
                .sorted()
                .toArray();
    }
}
