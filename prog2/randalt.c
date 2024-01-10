#include <stdio.h>
#include <stdlib.h>

int main(){
    
    int i;
    double num;
   
    double v[30]={};
    for (i = 0 ; i<30 ;i++){
        v[i] = (rand() %100) + 100;
        v[i] = 0.01 * v[i];
        printf("%lf ",v[i]);
    }

    double a = 0;
    double media;
    for ( i = 0 ; i < 30 ; i++){
        a=a+v[i];
    }
    media = a / 30;
    printf("A altura media dos alunos é %lf\nOs alunos abaixo da media tem altura: ",media);
    for (i=0 ; i<30 ; i++){
        if (media > v[i])
            printf("%lf;",v[i]);
    }
}