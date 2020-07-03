//2563 색종이

#include <iostream>
using namespace std;

int main(void)
{
    ios_base ::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase;
    cin >> testCase;

    int arr[101][101] = {
        0,
    };
    int xh = 0;

    while (testCase--)
    {
        int x, y;
        cin >> x >> y;
        for (int i = x; i < x + 10; i++)
        {
            for (int j = y; j < y + 10; j++)
            {
                arr[i][j] = 1;
            }
        }
    }
    for (int i = 0; i < 100; i++)
    {
        for (int j = 0; j < 100; j++)
        {
            xh += arr[i][j];
        }
    }
    cout << xh;
    return 0;
}