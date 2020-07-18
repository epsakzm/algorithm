#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    int arr[100001];
    int DP[100001];
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int x;
        cin >> x;
        arr[i] = x;
    }
    DP[0] = arr[0];
    int result = DP[0];
    for (int i = 1; i < N; i++)
    {
        DP[i] = max(DP[i - 1] + arr[i], arr[i]);
        result = max(result, DP[i]);
    }
    cout << result << endl;
    return 0;
}