#include <iostream>
#include <string>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string str;
    int base;
    int a = 1;
    cin >> str >> base;
    int dec = 0;
    for (int i = 0; i < str.size() - 1; i++)
    {
        a *= base;
    }
    for (int i = 0; i < str.size(); i++)
    {
        int x;
        if (str[i] >= 65)
        {
            str[i] = tolower(str[i]);
            x = str[i] - 87;
        }
        else
        {
            x = str[i] - 48;
        }
        dec += x * a;
        a/=base;
    }
    cout << dec;

    return 0;
}