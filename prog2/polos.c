// programa para indicar se um numero é positivo ou negativo


#include <stdio.h>

int main()
{
    float numero;
    printf("por favor insira um valor positivo ou negativo: ");
    scanf("%f", &numero);

    if ( numero > 0 )
    {
        printf("o numero %f e positivo\n", numero);
    }
    else if (numero < 0 )
    {
        printf("o numero %f e negativo\n", numero);
    }
    else if (numero = 0)
    { 
        printf("o %f não e nem positivo nem negativo\n", numero);
    }
    else 
    {
        printf("entrada invalida\n");
    }

}





