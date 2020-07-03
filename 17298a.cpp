#include <bits/stdc++.h>
#define endl '\n'
using namespace std;
/*int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int N;
    cin >> N;
    int pos = 0;
    vector<int> v(N);
    vector<int> ans(N);
    for (int i = N - 1; i >= 0; i--)
        cin >> v[i];
    ans[0] = -1;
    for (int i = 1; i < N; i++)
    {
        int temp = -1;
        for (int j = i - 1; j >= 0; j--)
        {
            if (v[i] >= v[j])
                continue;
            temp = v[j];
            break;
        }
        ans[++pos] = temp;
    }
    for (int i = N - 1; i >= 0; i--)
        cout << ans[i] << ' ';
    return 0;
}
*/
//시간초과
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    vector<int> v(N), ans(N);
    stack<int> s;
    for (int i = 0; i < N; i++)
        cin >> v[i];
    for (int i = N - 1; i >= 0; i--)
    {
        while (!s.empty() && s.top() <= v[i])
            s.pop();
        if (s.empty())
            ans[i] = -1;
        else
            ans[i] = s.top();
        s.push(v[i]);
    }
    for (auto x : ans)
        cout << x << ' ';
}
