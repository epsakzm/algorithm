#include <iostream>
#include <string>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    char arr[5][15] = {
        '\0',
    };

    for (int i = 0; i < 5; i++)
    {
        cin >> arr[i];
    }
    for (int i = 0; i < 15; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            if (!arr[j][i])
            {
                continue;
            }
            cout << arr[j][i];
        }
    }
    return 0;
}