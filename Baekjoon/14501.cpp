#include <bits/stdc++.h>
using namespace std;

int Wait[1000] = {
    0,
};
int Score[1000] = {
    0,
};
int dp[1000] = {
    0,
};
int main(void)
{
    int N;
    int next;
    int result;
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        cin >> Wait[i] >> Score[i];
    }
    for (int i = N; i > 0; i--)
    {
        next = i + Wait[i] + 1;
        // if (next > N + 1) {
        //     dp[i] = dp[i + 1];
        // }
        dp[i] = max(dp[i + 1], dp[next] + Score[i]);
        result = max(dp[i], result);
    }
    cout << result << endl;
    return 0;
}
