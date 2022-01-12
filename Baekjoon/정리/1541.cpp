#include <iostream>
#include <string>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    string s, temp = "";
    int sum = 0;
    cin >> s;
    bool minus = false;
    for (auto x : s)
        if (x == '-' || x == '+')
        {
            if (minus)
                sum -= stoi(temp);
            else
                sum += stoi(temp);
            temp.clear();
            if (x == '-')
                minus = true;
        }
        else
            temp += x;
    if (minus)
        sum -= stoi(temp);
    else
        sum += stoi(temp);
    cout << sum << endl;
    return 0;
}