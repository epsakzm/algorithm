package programmers.impl;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42889
public class FailRate {

    class Stage {
        int stage;
        double failRate;

        Stage(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Stage[] stageList = new Stage[N];
        for (int i = 0; i < N; ++i) {
            final int currentStage = i + 1;
            int failCount = 0;
            int stageTotalCount = 0;
            for (int stage : stages) {
                if (stage >= currentStage)
                    stageTotalCount++;
                if (stage == currentStage)
                    failCount++;
            }
            stageList[i] = new Stage(currentStage, stageTotalCount == 0 ? 0 : (double) failCount / stageTotalCount);
        }
        Arrays.sort(stageList, (s1, s2) -> Double.compare(s2.failRate, s1.failRate));

        for (int i = 0; i < N; ++i)
            answer[i] = stageList[i].stage;
        return answer;
    }

    public static void main(String[] args) {
        int N = 4;
        int[] stages = { 4, 4, 4, 4, 4 };
        System.out.println(Arrays.toString(new FailRate().solution(N, stages)));
    }
}
