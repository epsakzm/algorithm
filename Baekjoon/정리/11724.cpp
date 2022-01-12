#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
#define MAX 1001
using namespace std;
vector<int> arr[MAX];
bool visited[MAX];
void dfs(int x)
{
    visited[x] = true;
    for (int i = 0; i < arr[x].size(); i++)
    {
        int nx = arr[x][i];
        if (!visited[nx])
            dfs(nx);
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;
    while (M--)
    {
        int x, y;
        cin >> x >> y;
        arr[x].push_back(y);
        arr[y].push_back(x);
    }
    int cnt = 0;
    for (int i = 1; i <= N; i++)
    {
        if (!visited[i])
        {
            dfs(i);
            cnt++;
        }
    }
    cout << cnt << endl;
    return 0;
}