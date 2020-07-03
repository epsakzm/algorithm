#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    ll N;
    ll D[91];
    D[1] = 1;
    D[2] = 1;
    cin >> N;
    for (int i = 3; i < 91; i++)
    {
        D[i] = D[i - 1] + D[i - 2];
    }
    cout << D[N];
    return 0;
}