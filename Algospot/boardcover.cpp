#include <bits/stdc++.h>

using namespace std;

int h, w;
int board[20][20];

const int coverType[4][3][2] = {
    {{0, 0}, {1, 0}, {0, 1}}, // ㄱ 왼쪽으로 90
    {{0, 0}, {0, 1}, {1, 1}}, // ㄱ
    {{0, 0}, {1, 0}, {1, 1}}, // ㄴ
    {{0, 0}, {1, 0}, {1, -1}} // ㄴ 왼쪽으로 90
};

/**
 * mode = 1이면 덮고, -1이면 덮었던 블록을 없앤다.
 * 겹치거나, 검은 칸을 덮을 때 false 반환.
 */
bool judge(int y, int x, int type, int mode)
{
    bool ok = true;
    for (int i = 0; i < 3; ++i)
    {
        const int ny = y + coverType[type][i][0];
        const int nx = x + coverType[type][i][1];
        if (ny < 0 || ny >= h || nx < 0 || nx >= w)
            ok = false;
        else if ((board[ny][nx] += mode) > 1)
            ok = false;
    }
    return ok;
}

/**
 * board의 모든 빈 칸을 덮을 수 있는 방법의 수를 반환한다.
 * board[][] = 1 은 이미 덮힌 칸 혹은 검은 칸
 * board[][] = 0 은 아직 덮히지 않은 칸
 */
int cover()
{
    bool found = false;
    // 가장 윗줄 왼쪽의 칸 부터 찾음
    int x, y;
    for (int i = 0; i < h; ++i)
    {
        for (int j = 0; j < w; ++j)
        {
            if (board[i][j] == 0)
            {
                y = i;
                x = j;
                found = true;
                break;
            }
        }
        if (found)
            break;
    }
    // 모든 칸을 덮어서 board[][] = 0 인 부분이 없으면 끝
    if (!found)
        return 1;
    int ret = 0;
    for (int type = 0; type < 4; ++type)
    {
        if (judge(y, x, type, 1))
            ret += cover();
        judge(y, x, type, -1);
    }
    return ret;
}

int main(void)
{
    int tc, cnt;
    string s;

    cin >> tc;
    while (tc--)
    {
        cin >> h >> w;
        for (int i = 0; i < h; ++i)
        {
            cin >> s;
            for (int j = 0; j < w; ++j)
            {
                if (s[j] == '#')
                    board[i][j] = 1;
                else
                {
                    board[i][j] = 0;
                    ++cnt;
                }
            }
        }
        if (cnt % 3 != 0)
            cout << "0"
                 << "\n";
        cout << cover() << "\n";
    }
    return 0;
}
