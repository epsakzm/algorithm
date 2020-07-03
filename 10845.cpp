#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    queue<int> q;
    int testCase;
    cin >> testCase;

    while (testCase--)
    {
        string s;
        cin >> s;
        if (s == "push")
        {
            int n;
            cin >> n;
            q.push(n);
        }
        else if (s == "pop")
        {
            if (!q.empty())
            {
                cout << q.front() << endl;
                q.pop();
            }
            else
            {
                cout << -1 << endl;
            }
        }
        else if (s == "size")
        {
            cout << q.size() << endl;
        }
        else if (s == "empty")
        {
            if (q.empty())
            {
                cout << "1" << endl;
            }
            else
            {
                cout << "0" << endl;
            }
        }
        else if (s == "front")
        {
            if (q.empty())
            {
                cout << -1 << endl;
            }
            else
            {
                cout << q.front() << endl;
            }
        }
        else if (s == "back")
        {
            if (q.empty())
            {
                cout << -1 << endl;
            }
            else
            {
                cout << q.back() << endl;
            }
        }
    }
    return 0;
}