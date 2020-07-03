#include <bits/stdc++.h>
#define endl '\n'
using namespace std;
int F, S, G, U, D;
bool visited[1000001];
int ok = 0;
int bfs(int start)
{
    queue<pair<int, int>> q;
    q.push({start, 0});
    visited[start] = true;
    while (!q.empty())
    {
        auto x = q.front();
        int curStage = x.first;
        int curSec = x.second;
        if (curStage == G)
        {
            return curSec;
        }
        q.pop();
        int upStage = curStage + U;
        int downStage = curStage - D;
        if (upStage <= F && !visited[upStage])
        {
            visited[upStage] = true;
            q.push(make_pair(upStage, curSec + 1));
        }
        if (downStage >= 1 && !visited[downStage])
        {
            visited[downStage] = true;
            q.push(make_pair(downStage, curSec + 1));
        }
    }
    return -1;
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> F >> S >> G >> U >> D;
    int ans = bfs(S);
    if (ans == -1)
        cout << "use the stairs" << endl;
    else
        cout << ans << endl;
    return 0;
}