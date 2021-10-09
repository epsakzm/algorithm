#include <iostream>
using namespace std;
char arr[101][101] = {0};
char arr2[101][101] = {0};
bool visited[101][101] = {false};
bool visited2[101][101] = {false};
int cnt = 0;
int scount = 0;
int N;

void dfs(const int x, const int y, const char c, int arrNum)
{
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < N)
        {
            if (arrNum == 1)
            {
                if (!visited[nx][ny] && arr[nx][ny] == c)
                {
                    visited[nx][ny] = true;
                    dfs(nx, ny, arr[nx][ny], arrNum);
                }
            }
            else if (arrNum == 2)
            {
                if (!visited2[nx][ny] && arr2[nx][ny] == c)
                {
                    visited2[nx][ny] = true;
                    dfs(nx, ny, arr2[nx][ny], arrNum);
                }
            }
        }
    }
}
int main(void)
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> arr[i][j];
        }
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (arr[i][j] == 'G')
                arr2[i][j] = 'R';
                else arr2[i][j] = arr[i][j];
        }
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (!visited[i][j])
            {
                visited[i][j] = true;
                cnt += 1;
                dfs(i, j, arr[i][j], 1);
            }
            if (!visited2[i][j])
            {
                visited2[i][j] = true;
                scount += 1;
                dfs(i, j, arr2[i][j], 2);
            }
        }
    }
    cout << cnt << ' ' << scount;
    return 0;
}
