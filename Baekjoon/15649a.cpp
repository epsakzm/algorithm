#include <bits/stdc++.h>
using namespace std;
const int MAX = 8 + 1;

int N, M;
int arr[MAX];
bool visited[MAX];

void dfs(int count)
{
    if (count == M)
    {
        for (int i = 0; i < M; i++)
        {
            cout << arr[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = 1; i <= N; i++)
    {
        if (!visited[i])
        {
            visited[i] = true;
            arr[count] = i;
            dfs(count + 1);
            visited[i] = false;
        }
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> M;
    dfs(0);
    return 0;
}
