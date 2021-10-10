#include<bits/stdc++.h>

using namespace std;

int n = 10;
vector<int> picked;

void printPicked() {
    for (int i = 0; i < picked.size(); ++i) {
        cout << picked[i];
    }
    cout << " ";
}

void pick(int toPick) {
    if (toPick == 0) {
        printPicked();
        return;
    }
    for (int next = picked.empty() ? 0 : picked.back() + 1; next < n; ++next) {
        picked.push_back(next);
        pick(toPick - 1);
        picked.pop_back();
    }
}

int main(void) {
    pick(5);
    return 0;
}