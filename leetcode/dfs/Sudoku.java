package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {

    private boolean check(int r, int c, char target, char[][] map) {
        for (int idx = 0; idx < 9; ++idx) {
            if (map[r][idx] == target)
                return false;
            if (map[idx][c] == target)
                return false;
        }

        int startR = r / 3 * 3;
        int startC = c / 3 * 3;

        for (int i = startR; i < startR + 3; i++)
            for (int j = startC; j < startC + 3; j++)
                if (map[i][j] == target)
                    return false;

        return true;
    }

    private void solve(int depth, List<int[]> list, char[][] board) {
        if (depth == list.size())
            return;

        for (int i = 1; i <= 9; ++i) {
            int x = list.get(depth)[0];
            int y = list.get(depth)[1];
            char num = (char) (i + '0');
            if (!check(x, y, num, board))
                continue;
            board[x][y] = num;
            solve(depth + 1, list, board);
            board[x][y] = '.';
        }
    }

    public void solveSudoku(char[][] board) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                if (board[i][j] == '.')
                    list.add(new int[] { i, j });
        solve(0, list, board);
        for (char[] cc : board) {
            System.out.println(Arrays.toString(cc));
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        new Sudoku().solveSudoku(board);
    }
}
