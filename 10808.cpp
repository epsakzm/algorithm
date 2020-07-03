#include<iostream>
#include<cstring>
using namespace std;

char str[100];
int arr[26] = {0, };
int main(void){

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> str;

    for(int i = 0; i< strlen(str); i++){
        arr[str[i]-97]++;
    }
    for(auto x : arr){
        cout << x << " ";
    }
    return 0;
}