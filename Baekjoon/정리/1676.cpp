#include <iostream>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    int cnt = 0;
    for (int i = 1; i <= n; i++)
    {
        if (!(i % 5))
            cnt++;
        if (!(i % (5 * 5)))
            cnt++;
        if (!(i % (5 * 5 * 5)))
            cnt++;
    }
    cout << cnt;
    return 0;
}