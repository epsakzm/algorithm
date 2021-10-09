#include <bits/stdc++.h>
#define endl '\n'
using namespace std;
int N, K;
const int MAX = 100001;
bool visited[MAX];
int bfs(void)
{
    queue<pair<int, int>> q;
    q.push({N, 0});
    visited[N] = true;
    while (!q.empty())
    {
        int curPos = q.front().first;
        int curSec = q.front().second;
        if (curPos == K)
        {
            return curSec;
        }
        q.pop();
        int minus = curPos - 1;
        int plus = curPos + 1;
        int move = curPos * 2;
        if (move < MAX && !visited[move])
        {
            visited[move] = true;
            q.push({move, curSec});
        }
        if (minus >= 0 && !visited[minus])
        {
            visited[minus] = true;
            q.push({minus, curSec + 1});
        }
        if (plus < MAX && !visited[plus])
        {
            visited[plus] = true;
            q.push({plus, curSec + 1});
        }
    }
    return -1;
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> K;
    cout << bfs() << endl;
    return 0;
}