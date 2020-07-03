#include <iostream>
#include <queue>
using namespace std;
int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    priority_queue<pair<int, int>> pq;
    for (int i = 0; i < N; i++)
    {
        int num;
        cin >> num;
        if (!num)
        {
            if (pq.empty())
            {
                cout << 0 << "\n";
                continue;
            }
            cout << -pq.top().first <<" "<<-pq.top().second << "\n";
            pq.pop();
        }
        else
            pq.push({-abs(num), -num});
    }
    return 0;
}