#include <iostream>
#include <cstring>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    char input[51];
    cin >> input;
    int height = 10;
    for (int i = 1; i < strlen(input); i++)
    {
        if (input[i - 1] == input[i])
        {
            height += 5;
        }
        else
        {
            height += 10;
        }
    }
    cout << height << endl;
    return 0;
}