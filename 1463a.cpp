#include <bits/stdc++.h>
using namespace std;
const int MAX = 100001;
int DP[MAX];

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    DP[1] = 0;
    for (int i = 2; i <= N; i++)
    {
        DP[i] = DP[i - 1] + 1;
        if (i % 2 == 0)
            DP[i] = min(DP[i], DP[i / 2] + 1);
        if (i % 3 == 0)
            DP[i] = min(DP[i], DP[i / 3] + 1);
    }
    cout << DP[N];
    return 0;
}