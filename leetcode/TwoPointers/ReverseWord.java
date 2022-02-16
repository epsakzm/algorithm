package leetcode.twopointers;

import java.util.StringTokenizer;

/**
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */

// https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWord {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            sb.append(new StringBuilder(st.nextToken()).reverse().toString());
            if (st.hasMoreTokens())
                sb.append(" ");
        }
        return sb.toString();
    }
}
