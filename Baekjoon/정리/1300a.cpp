#include <bits/stdc++.h>
using namespace std;
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, k;
    cin >> N >> k;
    int start = 1;
    int end = k;
    int result = 0;
    while (start <= end)
    {
        int mid = (start + end) / 2;
        long long num = 0;
        for (int i = 1; i <= N; i++)
            num += min(mid / i, N);
        if (num < k)
            start = mid + 1;
        else
        {
            result = mid;
            end = mid - 1;
        }
    }
    cout << result;
    return 0;
}