#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
int N, cnt = 1;
int apartments[26][26];
int visited[26][26];
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
vector<int> arr;
void dfs(int r, int c)
{
    for (int i = 0; i < 4; i++)
    {
        int nextR = r + dr[i];
        int nextC = c + dc[i];
        if (nextR >= 0 && nextC >= 0 && nextC < N && nextR < N && !visited[nextR][nextC] && apartments[nextR][nextC])
        {
            visited[nextR][nextC] = 1;
            cnt++;
            dfs(nextR, nextC);
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
            scanf("%1d", &apartments[i][j]);
        }
    }
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (!visited[i][j] && apartments[i][j])
            {
                visited[i][j] = 1;
                ans++;
                dfs(i, j);
                arr.push_back(cnt);
                cnt = 1;
            }
        }
    }
    sort(arr.begin(), arr.end());
    cout << ans << endl;
    for (auto x : arr)
        cout << x << endl;
    return 0;
}