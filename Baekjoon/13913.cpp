#include <iostream>
#include <queue>
using namespace std;

const int MAX = 100001;
bool visited[MAX] = {false};
int back[MAX];
queue<pair<int, int>> q;
vector<int> v;
int bfs(int from, int to)
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
            int location = curLoc;
            while (location != from)
            {
                v.push_back(location);
                location = back[location];
            }
            v.push_back(from);
            return curSec;
        }
        if (curLoc + 1 < MAX && !visited[curLoc + 1])
        {
            visited[curLoc + 1] = true;
            back[curLoc + 1] = curLoc;
            q.push(make_pair(curLoc + 1, curSec + 1));
        }
        if (curLoc - 1 >= 0 && !visited[curLoc - 1])
        {
            visited[curLoc - 1] = true;
            back[curLoc - 1] = curLoc;
            q.push(make_pair(curLoc - 1, curSec + 1));
        }
        if (curLoc * 2 < MAX && !visited[curLoc * 2])
        {
            visited[curLoc * 2] = true;
            back[curLoc * 2] = curLoc;
            q.push(make_pair(curLoc * 2, curSec + 1));
        }
    }
    return -1;
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;
    cout << bfs(N, K) << endl;
    
    vector<int>::reverse_iterator r_iter;
    for (r_iter = v.rbegin(); r_iter != v.rend(); r_iter++)
    {
        cout << *r_iter << ' ';
    }
    return 0;
}
