#include <iostream>
#include <string>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    getline(cin, s);
    string ans;
    for (auto x : s)
    {
        if ((x >= 'A' && x <= 'M') || (x >= 'a' && x <= 'm'))
        {
            ans += (char)(x + 13);
        }
        else if (x == ' ' || (x >= '0' && x <= '9'))
        {
            ans += x;
        }
        else
        {
            ans += (char)(x - 13);
        }
    }
    cout << ans << endl;
    return 0;
}