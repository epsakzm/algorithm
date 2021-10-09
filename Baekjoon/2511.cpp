#include <iostream>
#include <array>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    const int size = 10;
    array<int, size> arr1;
    array<int, size> arr2;
    int aScore = 0, bScore = 0;
    int a = 0, b = 0;
    bool winnerA;

    for (int i = 0; i < size; i++)
    {
        cin >> arr1[i];
    }
    for (int i = 0; i < size; i++)
    {
        cin >> arr2[i];
    }
    for (int i = 0; i < size; i++)
    {
        if (arr1[i] > arr2[i])
        {
            aScore += 3;
            winnerA = true;
        }
        else if (arr1[i] < arr2[i])
        {
            bScore += 3;
            winnerA = false;
        }
        else
        {
            aScore++;
            bScore++;
        }
    }
    cout << aScore << ' ' << bScore << endl;
    if (aScore > bScore)
    {
        cout << 'A' << endl;
    }
    else if (aScore < bScore)
    {
        cout << 'B' << endl;
    }
    else
    {
        if (aScore == 10 && bScore == 10)
        {
            cout << 'D' << endl;
        }
        else
        {
            if (winnerA)
            {
                cout << 'A' << endl;
            }
            else
            {
                cout << 'B' << endl;
            }
        }
    }
    return 0;
}