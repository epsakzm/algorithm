#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase;
    cin >> testCase;
    int m = 0;
    int x;
    stack<int> s;
    string ans;
    while (testCase--)
    {
        int x;
        cin >> x;
        if (x > m)
        {
            while (x > m)
            {
                s.push(++m);
                ans += '+';
            }
            s.pop();
            ans += '-';
        }
        else
        {
            bool found = false;
            if (!s.empty())
            {
                int top = s.top();
                s.pop();
                ans += '-';
                if (x == top)
                {
                    found = true;
                }
            }
            if (!found)
            {
                cout << "NO" << '\n';
                return 0;
            }
        }
    }
    for (auto x : ans)
        cout << x << '\n';
    return 0;
}