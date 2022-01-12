#include<cstdio>

int main(void){
    int x;
    int num;
    int cnt = 0;
    scanf("%d", &x);
    for(int i = 0 ; i < 5; i++){
        scanf("%d", &num);
        if(num==x){
            cnt++;
        }
    }
    printf("%d", cnt);
}