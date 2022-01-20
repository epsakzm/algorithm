package Baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1652 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int r, c;
        r = c = 0;
        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            if (line.matches("[.]{2}"))
                ++r;
            sb.append(line);
        }
        String s = sb.toString();
        for (int i = 0; i < n; ++i)
            if (s.substring(i, i + n).matches("[.].{" + (n - 1) + "}[.]"))
                ++c;
        bw.write(r + " " + c);
        bw.flush();
        bw.close();
        br.close();
    }
}