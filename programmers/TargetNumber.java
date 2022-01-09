package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/43165
public class TargetNumber {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    // 63
    public void dfs(int value, int depth, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (value == target)
                ++answer;
            return;
        }

        dfs(value - numbers[depth], depth + 1, numbers, target);
        dfs(value + numbers[depth], depth + 1, numbers, target);
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(new TargetNumber().solution(numbers, target));
    }
}
