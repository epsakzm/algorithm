package programmers.string;

// https://programmers.co.kr/learn/courses/30/lessons/12948
public class PhoneNumberMask {
    public String solution(String phone_number) {
        int len = phone_number.length();
        return "*".repeat(len - 4) + phone_number.substring(len - 4, len);
    }
}
