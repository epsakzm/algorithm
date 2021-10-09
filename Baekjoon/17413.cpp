#include <iostream>
#include <stack>
#include <string>
#include <algorithm>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    getline(cin, s);
    string temp;
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] == '<')
        {
            reverse(temp.begin(), temp.end());
            cout << temp;
            temp.clear();
            temp += s[i];
            while (s[i] != '>')
            {
                temp += s[++i];
            }
            cout << temp;
            temp.clear();
        }
        else if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= '0' && s[i] <= '9'))
        {
            temp += s[i];
        }
        else
        {
            reverse(temp.begin(), temp.end());
            cout << temp << ' ';
            temp.clear();
        }
    }
    reverse(temp.begin(), temp.end());
    cout << temp << endl;
    return 0;
}