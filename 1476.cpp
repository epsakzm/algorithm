#include <iostream>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int E, S, M;
    cin >> E >> S >> M;
    int ans = 1;
    int e = 1, s = 1, m = 1;
    while (true)
    {
        if(e==E && s==S && M==m)break;
        e++;s++;m++;ans++;
        if (e > 15)
            e = 1;
        if (s > 28)
            s = 1;
        if (m > 19)
            m = 1;
    }
    cout << ans << endl;
    return 0;
}