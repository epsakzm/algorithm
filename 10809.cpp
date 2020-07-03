#include <iostream>
#include <string>
#include<array>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;
    int arr[26];
    fill_n(arr, 26, -1);
    bool used[26] = {
        0,
    };
    for (int i = 0; i < s.length(); i++)
    {
        if (!used[s[i] - 97])
        {
            arr[s[i] - 97] = i;
        }
        used[s[i] - 97] = true;
    }
    for (auto x : arr)
    {
        
        cout << x << " ";
    }
    return 0;
}