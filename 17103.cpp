#include <iostream>
#include <vector>

using namespace std;

vector<int> v;
const int N = 1000001;
bool isNotPrime[N] = {false};
void eratosthenes()
{
    for (int i = 2; i < N; i++)
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
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int testCase;
    cin >> testCase;
    int cnt = 0;
    eratosthenes();
    while (testCase--)
    {
        int x;
        cin >> x;
        for(int i = 0; i < v.size(); i++){
            if(x-v[i] < 0)break;
            if(!isNotPrime[x-v[i]] && (x-v[i])>=x/2)
                cnt++;
        }
        cout << cnt << '\n';
        cnt = 0;
    }
    return 0;
}