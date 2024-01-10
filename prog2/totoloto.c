#include <stdio.h>
#include <stdlib.h>
int main(){
    int i = 7;
    int c;
    int j = 7;
    int v[i][j];
    int a = 0;
    int b;
    int f[c];
    for (i=0 ; i<7 ; i++){
        for (j=0 ; j<7 ; j++){
            if (1){
                a++;
                v[i][j] = a;
            }
        }
    }
    printf("por favor isira o numero de jogadas: ");
    scanf("%d",&b);
   //96 é para simboizar o x pois n o consegui inserir
    for (i=0 ; i<7 ; i++){
        for (j=0 ; j<7 ; j++){
            for (c=0;c<b;c++){
                f[c] = (rand() %49);
                if (v[i][j]== f[c]){
                    v[i][j] = 96;
            }
            }
            printf("%d;",v[i][j]);
        }
        printf("\n");
    }
}