#include <iostream>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase;
    cin >> testCase;
    int D[12];
    D[1] = 1;
    D[2] = 2;
    D[3] = 4;
    while (testCase--)
    {
        int x;
        cin >> x;
        for (int i = 4; i <= x; i++)
        {
            D[i] = D[i - 1] + D[i - 2] + D[i - 3];
        }
        cout << D[x] << '\n';
    }
    return 0;
}