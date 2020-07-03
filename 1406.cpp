#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main(void)
{

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    stack<char> left, right;
    string sen;
    int testCase;

    cin >> sen >> testCase;
    for (auto x : sen)
    {
        left.push(x);
    }
    while (testCase--)
    {
        char str;
        cin >> str;

        if (str == 'P')
        {
            char c;
            cin >> c;
            left.push(c);
        }
        else if (str == 'L')
        {
            if (!left.empty())
            {
                right.push(left.top());
                left.pop();
            }
        }
        else if (str == 'D')
        {
            if (!right.empty())
            {
                left.push(right.top());
                right.pop();
            }
        }
        else if (str == 'B')
        {
            if (!left.empty())
            {
                left.pop();
            }
        }
    }
    while (!left.empty())
    {
        right.push(left.top());
        left.pop();
    }
    while (!right.empty())
    {
        cout << right.top();
        right.pop();
    }
    return 0;
}