#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

long long gcd(long long a, long long b)
{
    if (b == 0)
        return a;
    else
    {
        return gcd(b, a % b);
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    long long N;
    long long S;
    cin >> N >> S;
    long long *ch = new long long[N];
    long long *dis = new long long[N];
    for (int i = 0; i < N; i++)
    {
        cin >> ch[i];
        dis[i] = S - ch[i];
    }
    long long g = dis[0];
    for (int i = 0; i < N; i++)
    {
        g = gcd(g, dis[i]);
    }
    cout << abs(g);
    return 0;
}