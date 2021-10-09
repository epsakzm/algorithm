#include <iostream>
#include <string>
#include <bitset>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string s;
    cin >> s;
    bool pos = false;
    for (auto x : s)
    {
        int a = x - 48;
        if (pos)
            cout << bitset<3>(a);
        else
        {
            switch (a)
            {
            case 0:
                cout << "0";
                break;
            case 1:
                cout << "1";
                break;
            case 2:
                cout << "10";
                break;
            case 3:
                cout << "11";
                break;
            default:
                cout << bitset<3>(a);
                break;
            }
            pos = true;
        }
    }
    return 0;
}