#include <iostream>
using namespace std;

int main(void)
{
    ios_base ::sync_with_stdio(false);
    cin.tie(nullptr);
    int M, N, sum = 0, min = 0, mul, i = 1;
    cin >> M >> N;
    while (true)
    {
        mul = i * i;
        if (mul > N)
            break;
        if (mul <= N && mul >= M)
        {
            sum += mul;
            if (min == 0)
            {
                min = mul;
            }
        }
        i++;
    }
    if (sum == 0)
        cout << -1;
    else
    {
        cout << sum << endl
             << min << endl;
    }
    return 0;
}