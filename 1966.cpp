#include <bits/stdc++.h>
using namespace std;
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int count = 0;
    int testCase;
    cin >> testCase;
    int n, m;
    while (testCase--)
    {
        count = 0;
        cin >> n >> m;
        queue<pair<int, int>> q;
        priority_queue<int> pq;
        for (int j = 0; j < n; ++j)
        {
            int x;
            cin >> x;
            q.push({j, x});
            pq.push(x);
        }
        while (!q.empty())
        {
            int index = q.front().first;
            int value = q.front().second;
            q.pop();
            if (pq.top() == value)
            {
                pq.pop();
                count++;
                if (index == m)
                {
                    cout << count << endl;
                    break;
                }
            }
            else
                q.push({index, value});
        }
    }
}