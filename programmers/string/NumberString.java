package programmers.string;

//https://programmers.co.kr/learn/courses/30/lessons/81301
public class NumberString {
    public int solution(String s) {
        String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        for (int i = 0; i < numbers.length; ++i)
            s = s.replaceAll(numbers[i], String.valueOf(i));
        return Integer.parseInt(s);
    }
}
