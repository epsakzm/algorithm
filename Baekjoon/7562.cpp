#include <bits/stdc++.h>
using namespace std;
const int MAX = 301;
int dx[] = {-1, 1, 2, 2, 1, -1, -2, -2};
int dy[] = {2, 2, 1, -1, -2, -2, -1, 1};
int visited[MAX][MAX];
bool check[MAX][MAX];
queue<pair<int, int>> q;
int sz;

void bfs(int curX, int curY)
{
    check[curX][curY] = true;
    q.push(make_pair(curX, curY));
    while (!q.empty())
    {
        auto a = q.front();
        int x = a.first;
        int y = a.second;
        q.pop();
        for (int i = 0; i < 8; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < sz && ny < sz)
            {
                if (!visited[nx][ny] && !check[nx][ny])
                {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.push({nx, ny});
                }
            }
        }
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int testCase;
    cin >> testCase;

    while (testCase--)
    {
        memset(visited, 0, sizeof(visited));
        memset(check, false, sizeof(check));
        cin >> sz;
        int curX, curY;
        cin >> curX >> curY;
        int moveX, moveY;
        cin >> moveX >> moveY;
        bfs(curX, curY);
        cout << visited[moveX][moveY] << '\n';
    }
    return 0;
}