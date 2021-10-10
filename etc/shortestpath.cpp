#include <bits/stdc++.h>
#define MAX 20
#define INF DBL_MAX

using namespace std;

// 도시의 수
int n;
// 두 도시 사이의 거리(비용)
double dist[MAX][MAX];

/**
 * path : 지금까지 만든 경로
 * visited : 각 도시의 방문 여부
 * currentLength : 지금까지 만든 경로 길이
 * 나머지 도시들을 모두 방문하는 경로들 중 가장 짧은 것의 길이를 반환
 */
double shortestPath(vector<int>& path, vector<bool>& visited, double currentLength) {
    // 종료 조건: 모든 도시 방문 후 시작 도시로 가고 종료
    if (path.size() == n)
        return currentLength + dist[path[0]][path.back()];
    double ret = INF;

    // 방문 도시를 모두 시도해본다.
    for (int next = 0; next < n; ++next) {
        if (visited[next])
            continue;
        int here = path.back();
        path.push_back(next);
        visited[next] = true;
        // 나머지 경로를 재귀 호출을 통해 완성하고 가장 짧은 경로의 길이를 얻는다.
        double cand = shortestPath(path, visited, currentLength + dist[here][next]);
        ret = min(ret, cand);
        visited[next] = false;
        path.pop_back();
    }
    return ret;
}
