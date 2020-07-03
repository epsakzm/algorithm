#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    string str, result;
    stack<char> s;
    cin >> str;
    for (auto c : str)
    {
        if (c >= 'A' && c <= 'Z')
            result += c;
        else
        {
            switch (c)
            {
            case '(':
                s.push(c);
                break;
            case '*':
            case '/':
                while (!s.empty() && (s.top() == '*' || s.top() == '/'))
                {
                    result += s.top();
                    s.pop();
                }
                s.push(c);
                break;
            case '+':
            case '-':
                while (!s.empty() && s.top() != '(')
                {
                    result += s.top();
                    s.pop();
                }
                s.push(c);
                break;
            case ')':
                while (!s.empty() && s.top() != '(')
                {
                    result += s.top();
                    s.pop();
                }
                s.pop();
                break;
            }
        }
    }
    while (!s.empty())
    {
        result += s.top();
        s.pop();
    }
    cout << result << endl;
}