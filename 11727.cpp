#include <iostream>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    int D[1001];
    D[1] = 1;
    D[2] = 3;
    D[3] = 5;
    for (int i = 4; i <= N; i++)
    {
        D[i] = (D[i - 1] + 2 * D[i - 2])%10007;
    }
    cout << D[N];
    return 0;
}