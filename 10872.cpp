#include <iostream>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    int fact = 1;
    while (n--)
    {
        fact *= n+1;
    }
    cout << fact << endl;
    return 0;
}