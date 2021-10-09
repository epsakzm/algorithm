#include <iostream>
#include <array>

using namespace std;
inline int a(int n)
{
    int sum = 0;
    for (int i = n; i > 0; i--)
    {
        sum += i;
    }
    return sum;
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase;
    cin >> testCase;
    int *arr = new int[testCase];
    int score = 0, temp = 0;
    for (int i = 0; i < testCase; i++)
    {
        cin >> arr[i];
    }
    for (int i = 0; i < testCase; i++)
    {
        if (arr[i])
            temp++;
        else
        {
            score += a(temp);
            temp = 0;
        }
    }
    score += a(temp);
    cout << score;
    return 0;
}