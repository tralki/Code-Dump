#include<stdio.h>
#include<texto.h>


int i;
char m[50];
char l[50];
int a;
int b;
int c;


int main(){
    printf("Insira uma palavra ");
    gets(l);
    b = strLen(l);
    printf("\nO tamanho da string %d",b);
    printf("\nA string ao contrario = %s",strReverse(l , b));
    printf("\nA string %s igual ao contrario",isPalindrome(l , b));
    printf("\nA sua palavra tem %d vogais",vowelCount(l));
    printf("\nA sua palavra tem %d consuantes",consonanteCount(l));
    printf("\nA sua palavra escondida = %s",strSet(l));
}
