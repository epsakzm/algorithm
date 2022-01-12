#include <iostream>
#include <string>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    long long a, b, c, d;
    cin >> a >> b >> c >> d;
    string A, B;
    long long sum;
    A = to_string(a) + to_string(b);
    B = to_string(c) + to_string(d);
    sum = stoll(A) + stoll(B);
    cout << sum << endl;
    return 0;
}