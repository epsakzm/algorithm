#include <iostream>
#include <string>

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int A, B;
    int a = 1, b = 1;
    int testCase;
    cin >> A >> B >> testCase;
    int dec = 0;
    for (int i = 0; i < testCase-1; i++)
    {
        a *= A;
    }
    for(int i = 0; i < testCase; i++){
        int x;
        cin >> x;
        dec += a * x;
        a /= A;
    }
    while(dec > b){
        b *= B;
    }
    b /= B;
    while(true){
        int div = dec / b;
        dec %= b; // dec = 6;
        cout << div << " ";
        if(b==1)break;
        b /= B;
    }
    return 0;
}

/*
#include <iostream>
using namespace std;
void convert(int num, int base) {
    if (num == 0) return;
    convert(num/base, base);
    printf("%d ",num%base);
}
int main() {
    int a,b;
    cin >> a >> b;
    int n;
    cin >> n;
    int ans = 0;
    for (int i=0; i<n; i++) {
        int x;
        cin >> x;
        ans = ans * a + x;
    }
    convert(ans,b);
    return 0;
}
*/