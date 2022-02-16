package leetcode.twopointers;

// https://leetcode.com/problems/reverse-string/
public class ReverseString {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; ++i) {
            char temp;
            temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }
}
