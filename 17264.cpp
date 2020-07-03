#include <iostream>
#include <string>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int testCase;
    int N;
    cin >> testCase >> N;
    string *player = new string[N];
    int win, lose, need;
    int playerCount = 0;
    cin >> win >> lose >> need;
    int pos = 0;
    int score = 0;
    bool found = false;
    while (N--)
    {
        string name, WorL;
        cin >> name >> WorL;
        if (WorL == "W")
        {
            player[pos++] = name;
            playerCount++;
        }
    }
    string name;
    while (testCase--)
    {
        cin >> name;
        found = false;
        for (int i = 0; i < playerCount; i++)
        {
            if (name == player[i])
            {
                found = true;
            }
        }
        if (found)
        {
            score += win;
        }
        else
        {
            score -= lose;
        }
        if (score < 0)
            score = 0;
        else if (score >= need)
        {
            for(int i = 0; i<testCase+1; i++)
            getline(cin, name);
            cout << "I AM NOT IRONMAN!!" << '\n';
            return 0;
        }
    }
    cout << "I AM IRONMAN!!" << '\n';
    return 0;
}