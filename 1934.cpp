#include <iostream>
using namespace std;
int g(int a, int b)
{
    if (b == 0)
    {
        return a;
    }
    else
        return g(b, a % b);
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase;
    cin >> testCase;
    while (testCase--)
    {
        int a, b;
        cin >> a >> b;
        int gcd = g(a,b);//a>b ? g(a, b) : g(b,a);
        int lcm = a * b / gcd;
        cout << lcm << endl;
    }
    return 0;
}