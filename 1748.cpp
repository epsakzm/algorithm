#include <iostream>
#include <string>
using namespace std;
using ll = long long;
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    ll sum = 0;
    int ten = 1;
    int size = to_string(N).length();
    for (int i = 1; i < size; i++)
    {
        sum += 9 * ten * i;
        ten *= 10;
    }
    int cnt = 0;
    for(int i = ten; i <= N; i++){
        cnt++;
    }
    sum += size * cnt;
    cout << sum;
    return 0;
}