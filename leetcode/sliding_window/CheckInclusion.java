package leetcode.sliding_window;

import java.util.Arrays;

// https://leetcode.com/problems/permutation-in-string/
public class CheckInclusion {

    private boolean check(int[] win1, int[] win2) {
        System.out.println(Arrays.toString(win1));
        System.out.println(Arrays.toString(win2));
        for (int i = 0; i < 26; ++i)
            if (win1[i] != win2[i])
                return false;
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] win1 = new int[26], win2 = new int[26];
        int size = s1.length();
        for (char c : s1.toCharArray())
            win1[c - 'a']++;
        for (int i = 0; i <= s2.length() - size; ++i) {
            Arrays.fill(win2, 0);
            int idx = 0;
            while (idx < size) {
                win2[s2.charAt(i + idx) - 'a']++;
                idx++;
            }
            if (check(win1, win2))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(new CheckInclusion().checkInclusion(s1, s2));
    }
}
