#include <bits/stdc++.h>
using namespace std;
const int MAX = 51;
char arr[MAX][MAX];
bool visited[MAX][MAX];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
queue<pair<int, int>> q;
int r, c;
bool ok;

void dfs(int x, int y, int cnt, const int xidx, const int yidx)
{
    if (ok)
        return;
    visited[x][y] = true;

    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < r && ny >= 0 && ny < c)
        {
            if (!visited[nx][ny] && arr[nx][ny] == arr[x][y])
            {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1, xidx, yidx);
            }
            else if (xidx == nx && yidx == ny && cnt >= 4)
            {
                ok = true;
                return;
            }
        }
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> r >> c;
    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            cin >> arr[i][j];
        }
    }
    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            memset(visited, false, sizeof(visited));
            dfs(i, j, 1, i, j);
            if (ok)
            {
                cout << "Yes" << endl;
                return 0;
            }
        }
    }
    cout << "No" << endl;
    return 0;
}