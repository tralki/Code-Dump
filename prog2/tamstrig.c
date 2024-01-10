//escreva um procedimento que imprima o tamanho da string


#include<stdio.h>

int main(){
    char nome[30];
    int i;
    int a;
    printf("introduza o seu nome  :");
    scanf("%s", nome);

    for (i = 0; i<30 ; i++){
        if ( nome[i] != '\0'){
            a++;
        }
       
    }
    printf("%d",a);
}