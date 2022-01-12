#include <iostream>
using namespace std;
bool isPrime(int n)
{
    if (n < 2)
        return false;
    for (int i = 2; i * i <= n; i++)
        if (n % i == 0)
            return false;
    return true;
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int m, n;
    cin >> m >> n;
    for (int i = m; i <= n; i++)
    {
        if (isPrime(i))
        {
            cout << i << '\n';
        }
    }
    return 0;
}