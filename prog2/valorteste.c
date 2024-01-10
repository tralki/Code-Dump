// programa que valida o valor do teste


#include <stdio.h>

int main()
{
    int nota;
    printf("por favor insira a nota do seu teste(valor inteiro de 0 a 20): ");
    scanf("%d", &nota);

    if ( nota < 21 )
    {
        printf("a sua nota e valida");
    }
    else 
    {
        printf("entrada invalida");
    }
}