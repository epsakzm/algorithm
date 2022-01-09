package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12899
public class Programmers12899 {

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        String[] arr = { "4", "1", "2" };

        while (n > 0) {
            sb.append(arr[n % 3]);
            if (n % 3 == 0)
                n = n / 3 - 1;
            else
                n = n / 3;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Programmers12899().solution(10));
    }
}
