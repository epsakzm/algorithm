#include <iostream>
#include <queue>
using namespace std;

const int MAX = 100001;
bool visited[MAX] = {false};
int ans;
queue<pair<int, int>> q;

void bfs(int from, int to)
{
    q.push(make_pair(from, 0));
    visited[from] = true;
    while (!q.empty())
    {
        int curLoc = q.front().first;
        int curSec = q.front().second;
        q.pop();
        if (curLoc == to)
        {
            ans = curSec;
            break;
        }
        if (curLoc + 1 < MAX && !visited[curLoc + 1])
        {
            visited[curLoc + 1] = true;
            q.push(make_pair(curLoc + 1, curSec + 1));
        }
        if (curLoc - 1 >=0 && !visited[curLoc - 1])
        {
            visited[curLoc - 1] = true;
            q.push(make_pair(curLoc - 1, curSec + 1));
        }
        if (curLoc * 2 < MAX && !visited[curLoc * 2])
        {
            visited[curLoc * 2] = true;
            q.push(make_pair(curLoc * 2, curSec + 1));
        }
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;
    bfs(N, K);
    cout << ans;
    return 0;
}
