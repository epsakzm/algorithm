package programmers.greedy;

//https://programmers.co.kr/learn/courses/30/lessons/42883
public class Greedy3 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int N = number.length() - k;
        int last = 0;
        for (int len = N; len > 0; len--) {
            char max = '0';
            for (int i = last; i <= number.length() - len; i++) {
                if (max < number.charAt(i)) {
                    max = number.charAt(i);
                    last = i + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("12345".substring(0, "12345".length()));
        // 3234
        String number = "1231234"; // 4개 뽑음
        int k = 3;
        System.out.println(new Greedy3().solution(number, k));
    }
}
