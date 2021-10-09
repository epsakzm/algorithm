#include <iostream>
using namespace std;

int main(void)
{
    int N, M;
    bool VIP[41] = {false};
    int D[41];
    D[0] = 1;
    D[1] = 1;
    int cnt = 0;
    int result = 1;
    cin >> N >> M;
    while (M--)
    {
        int x;
        cin >> x;
        VIP[x] = true;
    }
    for (int i = 2; i <= N; i++)
        D[i] = D[i - 1] + D[i - 2];
    for (int i = 1; i <= N; i++)
    {
        if (VIP[i])
        {
            result *= D[cnt];
            cnt = 0;
            continue;
        }
        cnt++;
    }
    result *= D[cnt];
    cout << result;
    return 0;
}