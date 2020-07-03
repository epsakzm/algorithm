#include <iostream>
using namespace std;
int gcd(int a, int b)
{
    return b == 0 ? a : gcd(b, a % b);
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int arr[100];
    int testCase;
    cin >> testCase;
    while (testCase--)
    {
        long long sum = 0;
        int testCase2, g;
        cin >> testCase2;
        for (int i = 0; i < testCase2; i++)
        {
            cin >> arr[i];
        }
        for (int i = 0; i < testCase2; i++)
        {
            for (int j = i + 1; j < testCase2; j++)
            {
                g = gcd(arr[i], arr[j]);
                sum += g;
            }
        }
        cout << sum << '\n';
        sum = 0;
    }
    return 0;
}