#include<iostream>
#include<string>
#include<algorithm>
#include<vector>
using namespace std;

int main(void){

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;
    vector<string> v;
    string temp;
    for(int i = 0; i<s.length(); i++){
        for(int j = i; j < s.length(); j++){
            temp+=s[j];
        }
        v.push_back(temp);
        temp.clear();
    }
    sort(v.begin(), v.end());
    for(auto x : v){
        cout << x <<endl;
    }
    return 0;
}