package programmers.greedy;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42885
public class Greedy4 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;

        Arrays.sort(people);

        for (int right = people.length - 1; left <= right; right--) {
            if (people[right] + people[left] > limit)
                answer++;
            else {
                answer++;
                left++;
            }
        }

        return answer;
    }

    public int solution2(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        Arrays.sort(people);

        while (left < right) {
            if (people[left] + people[right] <= limit)
                left++;
            right--;
            answer++;
        }
        return left == right ? answer + 1 : answer;
    }

    public int solution3(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }

    // 50 50 70 80
    // 50 + 80 <= 100?
    // false -> answer++; right--; -> answer = 1, right = 2
    // 50 + 70 <= 100?
    // false -> answer++; right--; -> answer = 2, right = 1
    // 50 + 50 <= 100
    // true -> answer++ left++ right --; answer = 3, right = 0 left = 1

    public static void main(String[] args) {
        int[] people = { 70, 50, 80, 50 };
        int limit = 100;

        System.out.println(new Greedy4().solution(people, limit));
    }
}
