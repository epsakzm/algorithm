#include <iostream>
#include <vector>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    const int N = 1000001;
    vector<int> v;
    bool isNotPrime[N];
    int x;
    for (int i = 2; i < N - 1; i++)
    {
        if (!isNotPrime[i])
        {
            v.push_back(i);
            for (int j = i * 2; j < N; j += i)
            {
                isNotPrime[j] = true;
            }
        }
    }
    while (true)
    {
        cin >> x;
        if (x == 0)
            break;
        for (int i = 0; i < v.size(); i++)
        {
            if (!isNotPrime[x - v[i]])
            {
                cout << x << " = " << v[i] << " + " << x - v[i] << '\n';
                break;
            }
        }
    }
    return 0;
}
