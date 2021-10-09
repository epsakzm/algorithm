#include <iostream>
#include <queue>

using namespace std;

int main(void)
{
    ios_base ::sync_with_stdio(false);
    cin.tie(nullptr);
    queue<int> q;
    int N, K;
    cin >> N >> K;
    for (int i = 1; i <= N; i++)
    {
        q.push(i);
    }
    cout << "<";
    while (true)
    {
        if (q.size() == 1)
        {
            cout << q.front() << ">";
            break;
        }
        else
        {
            for (int i = 0; i < K - 1; i++)
            {
                q.push(q.front());
                q.pop();
            }
        }
        cout << q.front() << ", ";
        q.pop();
    }
    return 0;
}