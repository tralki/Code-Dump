#include<stdio.h>
#include<ctype.h>
int main(){
    char nome[30];
    int i;
    int a;
    printf("introduza o seu nome  :");
    scanf("%s", nome);

    for (i = 0; i<30 ; i++){
        if ( tolower(nome[i]) == 'a'){
            a++;
        }
    }
    if ( a > 0){
    printf("existem %d a(s)",a);
    } else{
        printf("não existe nenhum a");
    }
}
