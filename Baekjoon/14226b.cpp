#include <iostream>
#include <queue>
using namespace std;
typedef pair<pair<int, int>, int> p;
const int MAX = 1001;

int s;
bool v[1001][1001];
queue<p> q;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> s;
    q.push({{1, 0}, 0});
    v[1][0] = true;
    while (!q.empty())
    {
        int emoji = q.front().first.first;
        int copy = q.front().first.second;
        int time = q.front().second;
        q.pop();

        if (emoji == s)
        {
            cout << time;
            break;
        }
        if (emoji > 0 && emoji < MAX)
        {
            if (!v[emoji][emoji])
            {
                q.push({{emoji, emoji}, time + 1});
                v[emoji][emoji] = true;
            }
            if (emoji - 1 >= 0 && !v[emoji - 1][copy])
            {
                q.push({{emoji - 1, copy}, time + 1});
                v[emoji - 1][copy] = true;
            }
        }
        if (copy > 0 && emoji + copy < MAX)
        {
            if (!v[emoji + copy][copy])
            {
                q.push({{emoji + copy, copy}, time + 1});
                v[emoji + copy][copy] = true;
            }
        }
    }
}