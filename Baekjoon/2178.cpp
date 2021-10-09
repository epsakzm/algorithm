#include <bits/stdc++.h>
using namespace std;
const int MAX = 101;
int r, c;
int arr[MAX][MAX];
int visited[MAX][MAX];
queue<pair<int, int>> q;
int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

int bfs(int x, int y)
{
    q.push({x, y});
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
            if (nx >= 0 && ny >= 0 && nx < r && ny < c)
            {
                if (arr[nx][ny] && !visited[nx][ny])
                {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.push({nx, ny});
                }
            }
        }
    }
    return visited[r - 1][c - 1];
}
int main(void)
{
    cin.tie(nullptr);
    cin >> r >> c;
    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            scanf("%1d", &arr[i][j]);
        }
    }
    cout << bfs(0, 0) + 1 << '\n';
    return 0;
}