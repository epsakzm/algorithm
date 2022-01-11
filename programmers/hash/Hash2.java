package programmers.hash;

import java.util.*;

public class Hash2 {

    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < phone_book.length; ++i)
            set.add(phone_book[i]);

        for (int i = 0; i < phone_book.length; ++i) {
            String number = phone_book[i];
            for (int j = 1; j < number.length(); ++j)
                if (set.contains(number.substring(0, j)))
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
