#include <iostream>
using namespace std;

int arr[9][9];

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int xpos, ypos;
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            int x;
            cin >> x;
            arr[i][j] = x;
        }
    }
    int max = arr[0][0];
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            if (max < arr[i][j])
            {
                max = arr[i][j];
                xpos = i;
                ypos = j;
            }
        }
    }
    cout << max << endl
         << xpos+1 << " " << ypos+1;
    return 0;
}