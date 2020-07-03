#include <bits/stdc++.h>

#define MAX 100001
#define endl '\n'
using namespace std;

queue<int> q;
vector<int> graph[MAX];
int visited[MAX];
void dfs(int x)
{
    visited[x] = true;
    for (int i = 0; i < graph[x].size(); i++)
    {
        int next = graph[x][i];
        vector<int> v;
        v.push_back(next);
        for(int x : v){
            if(!visited[x]){
                dfs(x);
            }
        }
    }
}//1243
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int testCase;
    cin >> testCase;
    for (int i = 0; i < testCase-1; i++)
    {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    for (int i = 0; i < testCase; i++)
    {
        int a;
        cin >> a;
        q.push(a);
    }
    q.pop();
    dfs(1);
    if(q.empty()){
        cout << 1 <<endl;
    }
    else{
        cout << 0 << endl;
    }
    return 0;
}