#include <bits/stdc++.h>
using namespace std;
const int MAX = 51;
int r, c;
int arr[MAX][MAX];
bool visited[MAX][MAX];
int dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy[] = {1, -1, 1, 0, -1, 1, 0, -1};

void dfs(int x, int y)
{
    visited[x][y] = true;
    for (int i = 0; i < 8; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < r && ny < c)
        {
            if (!visited[nx][ny] && arr[nx][ny])
            {
                dfs(nx, ny);
            }
        }
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    while (1)
    {
        cin >> c >> r;
        if (c == 0 && r == 0)
        {
            break;
        }
        memset(arr, 0, sizeof(arr));
        memset(visited, false, sizeof(visited));
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                cin >> arr[i][j];
            }
        }
        int cnt = 0;
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (!visited[i][j] && arr[i][j])
                {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        cout << cnt << '\n';
    }
    return 0;
}