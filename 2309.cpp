#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    const int size = 9;
    vector<int> v(size);
    vector<int> ans;
    int sum = 0;
    int pos1, pos2;
    for (int i = 0; i < size; i++)
    {
        cin >> v[i];
        sum += v[i];
    }
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            if (i == j)
                continue;
            if (sum - (v[i] + v[j]) == 100)
            {
                pos1 = i;
                pos2 = j;
            }
        }
    }
    for (int i = 0; i < size; i++)
    {
        if (i == pos1 || i == pos2)
            continue;
        ans.push_back(v[i]);
    }
    sort(ans.begin(), ans.end());
    for (auto x : ans)
    {
        cout << x << endl;
    }
    return 0;
}