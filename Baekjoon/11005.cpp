#include <iostream>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    long long decimal;
    long long num;
    cin >> decimal >> num;
    long long x = 1;
    while (decimal >= x)
    {
        x *= num;
    }
    x /= num;
    while (true)
    {
        int div = decimal / x;
        if (div >= 10 && div <= num)
        {
            char c = div + 55;
            cout << c;
        }
        else
        {
            cout << div;
        }
        if (x == 1)
        {
            break;
        }
        decimal %= x;
        x /= num;
    }
    return 0;
}