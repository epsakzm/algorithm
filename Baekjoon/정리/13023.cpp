#include <bits/stdc++.h>

#define endl '\n'
#define MAX 2001
using namespace std;

int N, M;
bool visited[MAX], ok;
vector<int> v[MAX];
void dfs(int x, int cnt)
{
    if (cnt == 5)
    {
        ok = true;
        return;
    }
    visited[x] = true;
    for (int i = 0; i < v[x].size(); i++)
    {
        int next = v[x][i];
        if (!visited[next])
            dfs(next, cnt + 1);
        if (ok)
            return;
    }
    visited[x] = false;
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    for (int i = 0; i < N && !ok; i++)
    {
        memset(visited, false, sizeof(visited));
        dfs(i, 1);
    }
    if (ok)
        cout << 1 << endl;
    else
        cout << 0 << endl;
    return 0;
}