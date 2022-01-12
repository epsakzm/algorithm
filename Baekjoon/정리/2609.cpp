#include <iostream>
using namespace std;
int gcd(int a, int b)
{
    if (b == 0)
    {
        return a;
    }
    else
    {
        return gcd(b, a % b);
    }
}
int main(void)
{

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b;
    cin >> a >> b;
    int g = gcd(a, b);
    int l = a * b / g;
    cout << g << endl
         << l << endl;
    return 0;
}