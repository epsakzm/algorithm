#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(void)
{

    ios_base ::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase;
    cin >> testCase;
    string s;

    while (testCase--)
    {
        int x;
        cin >> x;
        while (x > 1)
        {
            if (x % 2)
            {
                s += '1';
            }
            else
            {
                s += '0';
            }
            x /= 2;
        }
        if (x != 0)
            s += '1';

        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] == '1')
            {
                cout << i << " ";
            }
        }
        s.clear();
    }
    return 0;
}