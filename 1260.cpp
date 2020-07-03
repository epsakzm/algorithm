#include <iostream>
#include <queue>
using namespace std;
const int MAX = 1001;
int N, M, V;
int mat[MAX][MAX];
int visit[MAX] = {0};
queue<int> q;

void dfs(int v)
{
    cout << v << ' ';
    visit[v] = 1;
    for (int i = 1; i <= N; i++)
    {
        if (!visit[i] && mat[v][i])
        {
            dfs(i);
        }
    }
}
void bfs(int v)
{
    q.push(v);
    visit[v] = 1;
    while (!q.empty())
    {
        v = q.front();
        q.pop();
        cout << v << ' ';
        for (int i = 1; i <= N; i++)
        {
            if (mat[v][i] && !visit[i])
            {
                visit[i] = 1;
                q.push(i);
            }
        }
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M >> V;
    for (int i = 0; i < M; i++)
    {
        int x, y;
        cin >> x >> y;
        mat[x][y] = mat[y][x] = 1;
    }
    dfs(V);
    cout << endl;
    for (int i = 0; i <= MAX; i++)
    {
        visit[i] = 0;
    }
    bfs(V);
    return 0;
}