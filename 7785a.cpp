#include <iostream>
#include <string>
#include <set>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase;
    cin >> testCase;
    set<string> s;
    while (testCase--)
    {
        string n, stat;
        cin >> n >> stat;
        if (stat == "enter")
            s.insert(n);
        else
            s.erase(n);
    }
    set<string>::reverse_iterator rev_iter;
    for (rev_iter = s.rbegin(); rev_iter != s.rend(); rev_iter++)
    {
        cout << *rev_iter << '\n';
    }
    return 0;
}

