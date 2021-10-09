//시간초과

#include <bits/stdc++.h>
using namespace std;
const int MAX = 1001;

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};
int r, c;
int arr[MAX][MAX];
bool arr2[MAX][MAX];

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> c >> r;
    int year = 0;
    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            cin >> arr[i][j];
            if (arr[i][j])
            {
                arr2[i][j] = true;
            }
        }
    }

    while (1)
    {
        bool ok[MAX][MAX];
        bool cont = false;
        memset(ok, false, sizeof(ok));
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                int x = i;
                int y = j;
                int cnt = 0;
                for (int k = 0; k < 4; k++)
                {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c)
                    {
                        if (!arr[x][y] && arr[nx][ny] == 1)
                        {
                            ok[x][y] = true;
                        }
                    }
                    if ((nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == -1) && !arr2[x][y])
                    {
                        cnt++;
                        if (cnt == 4)
                        {
                            cout << -1;
                            return 0;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (ok[i][j] && !arr[i][j])
                {
                    arr[i][j] = 1;
                    arr2[i][j] = true;
                }
            }
        }
        // for (int i = 0; i < r; i++)
        // {
        //     for (int j = 0; j < c; j++)
        //     {
        //         cout << arr[i][j] << ' ';
        //     }
        //     cout << endl;
        // }
        year++;
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (!arr2[i][j])
                {
                    cont = true;
                    break;
                }
            }
            if (cont)
                break;
        }
        if (cont)
            continue;
        cout << year;
        return 0;
    }
    return 0;
}