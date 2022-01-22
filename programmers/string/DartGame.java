package programmers.string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://programmers.co.kr/learn/courses/30/lessons/17682
public class DartGame {

    public int solution(String dartResult) {
        Matcher matcher = Pattern.compile("([0-9]+)([SDT])([*#]?)").matcher(dartResult);
        int[] scores = new int[3];
        int idx = 0;

        while (matcher.find()) {
            String scoreGroup = matcher.group(1);
            String sdtGroup = matcher.group(2);
            String optionGroup = matcher.group(3);

            int score = Integer.parseInt(scoreGroup);

            if (sdtGroup.equals("D"))
                score *= score;
            else if (sdtGroup.equals("T"))
                score *= score * score;

            if (optionGroup.equals("*")) {
                score *= 2;
                if (idx > 0)
                    scores[idx - 1] *= 2;
            }

            else if (optionGroup.equals("#"))
                score *= -1;

            scores[idx++] = score;
        }
        return Arrays.stream(scores).sum();
    }

    public static void main(String[] args) {
        int[] result = { 37, 9, 3, 23, 5, -4, 59 };
        String[] dartResult = { "1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*" };
        for (int i = 0; i < dartResult.length; ++i) {
            System.out.println(new DartGame().solution(dartResult[i] + " : " + result[i]));
        }
    }
}
