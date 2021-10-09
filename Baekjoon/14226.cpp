#include <bits/stdc++.h>
#define endl '\n'
using namespace std;
const int MAX = 1000 + 1;
int S;
bool visited[MAX][MAX];

int bfs(void)
{
    queue<pair<pair<int, int>, int>> q;
    q.push({{1, 0}, 0});
    visited[1][0] = true;
    while (!q.empty())
    {
        int emo = q.front().first.first;
        int clip = q.front().first.second;
        int time = q.front().second;
        if (emo == S)
        {
            return time;
        }
        q.pop();
        if (emo > 0 && emo < MAX)
        {
            //복사
            if (!visited[emo][emo])
            {
                q.push({{emo, emo}, time + 1});
                visited[emo][emo] = true;
            }
            if (emo - 1 >= 0 && !visited[emo - 1][clip])
            {
                q.push({{emo - 1, clip}, time + 1});
                visited[emo - 1][clip] = true;
            }
        }
        if (clip > 0 && emo + clip < MAX)
        {
            if (!visited[emo + clip][clip])
            {
                q.push({{emo + clip, clip}, time + 1});
                visited[emo + clip][clip] = true;
            }
        }
    }
    return -1;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> S;
    cout << bfs() << endl;
    return 0;
}