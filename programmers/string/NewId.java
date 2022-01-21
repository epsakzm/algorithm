package programmers;

public class NewId {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id
                .toLowerCase()
                .replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "");

        if (answer.equals(""))
            answer += "a";

        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        if (answer.length() < 3) {
            char last = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer += last;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("answer = " + new NewId().solution("abcdefghijklmn.p"));
    }
}
