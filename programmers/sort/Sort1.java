package programmers.sort;

import java.util.Arrays;

public class Sort1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int i = 0; i < commands.length; ++i) {
            int fromIndex = commands[i][0] - 1;
            int toIndex = commands[i][1];
            int index = commands[i][2];
            int[] newArr = Arrays.copyOfRange(array, fromIndex, toIndex);
            Arrays.sort(newArr);
            answer[idx++] = newArr[index - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

        System.out.println(Arrays.toString(new Sort1().solution(array, commands)));
    }
}
