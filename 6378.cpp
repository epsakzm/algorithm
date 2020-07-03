#include <iostream>
#include <cstring>
#include <string>
#include <cstdio>
#include <algorithm>

using namespace std;

int sum = 0;
int droot(string s)
{

    if (s.length() == 1)
        return sum;
    else
        sum = 0;
    for (auto x : s)
    {
        int n = x - 48;
        sum += n;
    }
    return droot(to_string(sum));
}
int main(void)
{

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    string s;
    while (true)
    {
        cin >> s;
        if (s == "0")
        {
            break;
        }
        else
        {
            if (s.length() == 1)
            {
                cout << s[0] - 48 << endl;
            }
            else
            {
                int digitalRoot = droot(s);
                cout << digitalRoot << endl;
            }
        }
    }
    return 0;
}