#include <bits/stdc++.h>
using namespace std;
const int MAX = 301;
int r, c;
int arr[MAX][MAX];
int visited[MAX][MAX];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
bool ok = false;
void melt(void)
{
    int ice[MAX][MAX];
    memset(ice, 0, sizeof(ice));
    for (int i = 1; i < r - 1; i++)
    {
        for (int j = 1; j < c - 1; j++)
        {
            if (arr[i][j])
            {
                int cnt = 0;
                for (int k = 0; k < 4; k++)
                {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (arr[nx][ny] == 0)
                        cnt++;
                }
                ice[i][j] = cnt;
            }
        }
    }
    for (int i = 1; i < r - 1; i++)
    {
        for (int j = 1; j < c - 1; j++)
        {
            arr[i][j] = max(0, arr[i][j] - ice[i][j]);
        }
    }
}
void check(int x, int y)
{
    visited[x][y] = true;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 1 && ny >= 1 && nx < r - 1 && ny < c - 1)
        {
            if (!visited[nx][ny] && arr[nx][ny])
            {
                check(nx, ny);
            }
        }
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> r >> c;
    int year = 0;
    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            cin >> arr[i][j];
        }
    }
    while (++year)
    {
        memset(visited, false, sizeof(visited));
        int cnt = 0;
        for (int i = 1; i < r - 1; i++)
        {
            for (int j = 1; j < c - 1; j++)
            {
                if (!visited[i][j] && arr[i][j])
                {
                    cnt++;
                    check(i, j);
                }
                if (cnt >= 2)
                {
                    ok = true;
                    break;
                }
            }
            if (ok)
            {
                break;
            }
        }
        if (ok)
        {
            cout << year - 1;
            break;
        }
        if (cnt == 0)
        {
            cout << 0;
            break;
        }
        melt();
    }
    return 0;
}