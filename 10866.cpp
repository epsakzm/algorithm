#include <iostream>
#include <deque>
#include <string>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase;
    cin >> testCase;
    deque<int> d;
    while (testCase--)
    {
        string s;
        cin >> s;
        if (s == "push_front")
        {
            int x;
            cin >> x;
            d.push_front(x);
        }
        else if (s == "push_back")
        {
            int x;
            cin >> x;
            d.push_back(x);
        }
        else if (s == "pop_front")
        {
            if (d.empty())
            {
                cout << "-1" << endl;
            }
            else
            {
                cout << d.front() << endl;
                d.pop_front();
            }
        }
        else if (s == "pop_back")
        {
            if (d.empty())
            {
                cout << "-1" << endl;
            }
            else
            {
                cout << d.back() << endl;
                d.pop_back();
            }
        }
        else if (s == "size")
        {
            cout << d.size() << endl;
        }
        else if (s == "empty")
        {
            cout << d.empty() << endl;
        }
        else if (s == "front")
        {
            if (d.empty())
            {
                cout << "-1" << endl;
            }
            else
            {
                cout << d.front() << endl;
            }
        }
        else if (s == "back")
        {
            if (d.empty())
            {
                cout << "-1" << endl;
            }
            else
            {
                cout << d.back() << endl;
            }
        }
    }
    return 0;
}