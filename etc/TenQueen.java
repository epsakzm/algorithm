package etc;

import java.util.Arrays;

public class TenQueen {
    static int count = 0;
    int[] row = new int[10];

    boolean check(int curIdx) {
        for (int newIdx = 0; newIdx < curIdx; ++newIdx) {
            if (row[curIdx] == row[newIdx])
                return false;
            if (Math.abs(row[curIdx] - row[newIdx]) == curIdx - newIdx)
                return false;
        }
        return true;
    }

    void dfs(int queenIdx) {
        if (queenIdx == 9) {
            count++;
            System.out.println(Arrays.toString(row));
            return;
        }

        for (int i = 0; i < 10; ++i) {
            row[queenIdx + 1] = i;
            if (check(queenIdx + 1))
                dfs(queenIdx + 1);
        }
    }

    public static void main(String[] args) {
        new TenQueen().dfs(-1);
        System.out.println(count);
    }
}
