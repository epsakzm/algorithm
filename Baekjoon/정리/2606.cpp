#include <iostream>
using namespace std;

int N, M;
const int MAX = 101;
int visit[MAX];
int mat[MAX][MAX];
int cnt = 0;
void dfs(int v){
    visit[v] = 1;
    for(int i = 1; i<=N; i++){
        if(!visit[i] && mat[v][i]){
            dfs(i);
            cnt++;
        }
    }
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int x, y;
        cin >> x >> y;
        mat[x][y] = mat[y][x] = 1;
    }
    dfs(1);
    cout << cnt;
    return 0;
}