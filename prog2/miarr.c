#include <stdio.h>

int main(){

    int v[5]={7,3,98,3,6};
    int i;
    int a = 100000000;
    for (i = 0;i<5;i++)
    {
       if (a > v[i]){
        a = v[i];
       }
    }
    printf("%d\n", a);
}