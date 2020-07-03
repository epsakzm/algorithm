#include <iostream>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase, balance;
    cin >> testCase >> balance;
    int *arr = new int[testCase];
    int cnt = 0;
    int tmp;
    for (int i = 0; i < testCase; i++)
    {
        cin >> arr[i];
    }
    for (int i = testCase-1; i >= 0; i--)
    {
        if (balance >= arr[i])
        {
            tmp = balance / arr[i];
            cnt += tmp;
            balance %= arr[i];
        }
    }
    cout << cnt << endl;
    return 0;
}