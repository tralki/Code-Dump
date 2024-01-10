#include<stdio.h>
#include"Array.h"

int a;
int b;

int main(){
    printf("Escola o tamanho da matriz: ");
    printf("\ncoluna = "); scanf("%d",&a);
    printf("linha = "); scanf("%d",&b);
    getMatriz(a,b);
}