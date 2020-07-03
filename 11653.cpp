#include <iostream>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    int i = 2;
    while (N != 1)
    {
        if (N % i == 0)
        {
            N /= i;
            cout << i << endl;
            continue;
        }
        i++;
    }
    return 0;
}