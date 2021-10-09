#include <iostream>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    int D[46];
    D[0] = 0;
    D[1] = 1;
    for (int i = 2; i <= N; i++)
        D[i] = D[i - 1] + D[i - 2];
    cout << D[N];
    return 0;
}