#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main(void)
{

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    stack<char> s;
    string str;
    bool last = false;
    int ans = 0;
    cin >> str;
    for (auto x : str)
    {
        if (x == '(')
        {
            s.push(x);
            last = false;
        }
        else
        {
            s.pop();
            if (last)
                ans++;
            else
                ans += s.size();
            last = true;
        }
    }
    cout << ans << '\n';
    return 0;
}