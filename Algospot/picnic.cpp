#include <bits/stdc++.h>

using namespace std;

int n;
bool fr[10][10];

int countPair(bool isPaired[10])
{
    bool found;
    int first;

    found = false;
    for (int i = 0; i < n; ++i)
    {
        if (!isPaired[i])
        {
            first = i;
            found = true;
            break;
        }
    }
    if (!found)
        return 1;
    int ret = 0;
    for (int pairWith = first + 1; pairWith < n; ++pairWith)
    {
        if (!isPaired[pairWith] && fr[first][pairWith])
        {
            isPaired[first] = isPaired[pairWith] = true;
            ret += countPair(isPaired);
            isPaired[first] = isPaired[pairWith] = false;
        }
    }
    return ret;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int tc, m, a, b;
    bool paired[10];

    cin >> tc;
    while (tc--)
    {
        memset(fr, false, sizeof(fr));
        memset(paired, false, sizeof(paired));
        cin >> n >> m;
        while (m--)
        {
            cin >> a >> b;
            fr[a][b] = true;
            fr[b][a] = true;
        }
        cout << countPair(paired) << "\n";
    }
    return 0;
}

/*
Input
3 
2 1 
0 1 
4 6 
0 1 1 2 2 3 3 0 0 2 1 3 
6 10 
0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5
Output
1
3
4
*/
