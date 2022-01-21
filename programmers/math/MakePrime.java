package programmers.math;

// https://programmers.co.kr/learn/courses/30/lessons/12977
public class MakePrime {
    int answer = 0;

    private boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); ++i)
            if (n % i == 0)
                return false;
        return true;
    }

    private void dfs(int number, int before, int depth, int[] nums, boolean[] visited) {
        if (depth == 3) {
            if (isPrime(number))
                ++answer;
            return;
        }
        for (int i = before; i < nums.length; ++i)
            if (!visited[i]) {
                visited[i] = true;
                dfs(number + nums[i], i, depth + 1, nums, visited);
                visited[i] = false;
            }
    }

    public int solution(int[] nums) {
        dfs(0, 0, 0, nums, new boolean[nums.length]);
        return answer;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3, 4 }, { 1, 2, 7, 6, 4 } };
        System.out.println(new MakePrime().solution(nums[0]));
        System.out.println(new MakePrime().solution(nums[1]));
    }
}
