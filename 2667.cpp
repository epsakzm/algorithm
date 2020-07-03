#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
bool visited[26][26];
int arr[26][26];
int num = 1;
vector<int> v;
void dfs(int x, int y)
{
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && ny < 26 && nx < 26)
        {
            if (!visited[nx][ny] && arr[nx][ny])
            {
                num++;
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}
int main(void)
{
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            scanf("%1d", &arr[i][j]);
    int count = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (!visited[i][j] && arr[i][j])
            {
                visited[i][j]  = true;
                count++;
                dfs(i, j);
                v.push_back(num);
                num = 1;
            }
        }
    }
    cout << count << '\n';
    sort(v.begin(), v.end());
    for (auto x : v)
        cout << x << '\n';
    return 0;
}