#include <iostream>
using namespace std;

int main(void)
{

    ios_base ::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase = 10;
    int out, in;
    int arr[11] = {
        0,
    };
    int pos = 0;
    int max;
    while (testCase--)
    {
        cin >> out >> in;
        arr[pos] -= out;
        arr[pos] += in;
        arr[pos+1] = arr[pos];
        pos++;
    }
    max = arr[0];
    for (int i = 0; i < 10; i++)
        if (arr[i] > max)
            max = arr[i];
    cout << max;
    return 0;
}