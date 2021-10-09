#include <iostream>
using namespace std;

int main(void)
{
    ios_base ::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase;
    cin >> testCase;
    for (int i = 0; i < testCase; i++)
    {
        for (int j = 0; j < testCase - i - 1; j++)
            cout << " ";
        for (int j = 0; j < 2 * i + 1; j++)
            cout << "*";
        cout << endl;
    }
    for (int i = 1; i < testCase; i++)
    {
        for (int j = 0; j < i; j++)
            cout << " ";
        for (int j = 0; j < 2 * (testCase - i) - 1; j++)
            cout << "*";
        cout << endl;
    }
    return 0;
}