#include <bits/stdc++.h>
#define INF INT_MAX
#define SWITCHES 10
#define CLOCKS 16

using namespace std;

// 스위치에 연결된 시계를 배열에 저장한다.
const bool linked[SWITCHES][CLOCKS] = {
    {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
    {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0},
    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
    {0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
    {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}};

// 모두 12시를 가리키고 있는 지 확인
bool isAligned(const vector<int> &clocks)
{
    for (int i = 0; i < CLOCKS; ++i)
    {
        if (clocks[i] != 12)
            return false;
    }
    return true;
}

// 스위치를 한번 누르는 경우 연결된 시계들의 시간이 3시간씩 지남(12 + 3 = 3)
void push(vector<int> &clocks, int switchNumber)
{
    for (int clock = 0; clock < CLOCKS; ++clock)
    {
        if (linked[switchNumber][clock])
        {
            clocks[clock] += 3;
            if (clocks[clock] == 15)
                clocks[clock] = 3;
        }
    }
}

// 스위치를 0번부터 3번까지 누르는 경우를 모두 시도한다.
int solve(vector<int> &clocks, int switchNumber)
{
    if (switchNumber == SWITCHES)
        return isAligned(clocks) ? 0 : INF;
    int ret = INF;
    for (int cnt = 0; cnt < 4; ++cnt)
    {
        ret = min(ret, cnt + solve(clocks, switchNumber + 1));
        push(clocks, switchNumber);
    }
    return ret;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc, res;
    vector<int> clocks(CLOCKS);

    cin >> tc;
    while (tc--)
    {
        for (int i = 0; i < CLOCKS; ++i)
            cin >> clocks[i];
        res = solve(clocks, 0);
        if (res == INF)
            cout << -1 << "\n";
        else
            cout << res << "\n";
    }
    return 0;
}
