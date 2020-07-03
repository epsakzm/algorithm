#include <iostream>
#include <vector>
using namespace std;
const int MAX = 1001;
bool isNotPrime[MAX] = {false};
vector<int> v;
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;
    int cnt = 0;
    int ans;
    for (int i = 2; i <= N; i++)
    {
        if (!isNotPrime[i])
        {
            for (int j = i; j <= N; j += i)
            {
                if (isNotPrime[j])
                    continue;
                isNotPrime[j] = true;
                v.push_back(j);
            }
        }
    }
    cout << v[K - 1];
    return 0;
}