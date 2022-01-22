package programmers.impl;

import java.util.Calendar;
import java.util.Locale;

// programmers - 2016년
public class Year2016 {
    public String solution(int a, int b) {
        return new Calendar.Builder()
                .setDate(2016, a - 1, b)
                .build()
                .getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US)
                .toUpperCase();
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(new Year2016().solution(a, b));

    }
}
