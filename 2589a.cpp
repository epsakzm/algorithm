#include <bits/stdc++.h>

using namespace std;

char arr[51][51];
int visited[51][51] = {0};
int r, c;
int bfs(int x, int y)
{
    memset(visited, 0, sizeof(visited));
    queue<pair<int, int>> q;
    int result = 0;
    int dx[] = {0, 0, 1, -1};
    int dy[] = {1, -1, 0, 0};
    q.push({x, y});
    visited[x][y] = 1;
    while (!q.empty())
    {
        auto a = q.front();
        int x = a.first;
        int y = a.second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c)
            {
                if (!visited[nx][ny] && arr[nx][ny] == 'L')
                {
                    q.push({nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;
                    result = max(result, visited[nx][ny]);
                }
            }
        }
    }
    return result - 1;
}

int main(void)
{
    cin >> r >> c;
    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            cin >> arr[i][j];
        }
    }
    int ans = 0;
    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            if (arr[i][j] == 'L')
            {
                ans = max(ans, bfs(i, j));
            }
        }
    }
    cout << ans;
    return 0;
}