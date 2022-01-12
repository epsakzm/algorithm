#include <cstdio>

int main(void)
{
    int x, y;
    scanf("%d %d", &x, &y);
    if(x==2 && y==18){
        printf("Special");
    }
    else if(x>2 ||(x==2 && y>18)){
        printf("After");
    }
    else{
        printf("Before");
    }
    return 0;
}