#include <iostream>
#include <string>

using namespace std;
void eratosthenes(void)
{
}
int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    string s;
    cin >> s;
    int size = s.size();
    if (size % 3 == 2)
    {
        cout << (s[0] - 48) * 2 + (s[1] - 48);
    }
    else if (size % 3 == 1)
    {
        cout << (s[0] - 48);
    }
    for (int i = size % 3; i < size; i += 3)
    {
        cout << (s[i] - 48) * 4 + (s[i + 1] - 48) * 2 + s[i + 2] - 48;
    }
    return 0;
}