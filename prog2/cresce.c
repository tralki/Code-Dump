// organizar 3 numeros reais

#include <stdio.h>

int main()
{
    float numero1;
    float numero2;
    float numero3;
    printf("insira um numero real ");
    scanf("%f", &numero1);
    printf("insira outro numero real ");
    scanf("%f", &numero2);
    printf("insira pela ultima vez um numero real ");
    scanf("%f", &numero3);
   
    if (numero1 > numero2 && numero2 > numero3)
    {
        printf("%.2f < %.2f < %.2f",numero3,numero2,numero1);
    }
    else if (numero1 > numero3 && numero3 > numero2)
    {
        printf("%.2f < %.2f < %.2f",numero2,numero3,numero1);
    }
    else if (numero2 > numero1 && numero1 > numero3)
    {
        printf("%.2f < %.2f < %.2f",numero3,numero1,numero2);
    }
    else if (numero2 > numero3 && numero3 > numero1)
    {
        printf("%.2f < %.2f < %.2f",numero1,numero3,numero2);
    }
    else if (numero3 > numero1 && numero1 > numero2)
    {
        printf("%.2f < %.2f < %.2f",numero2,numero1,numero3);
    }
    else if (numero3 > numero2 && numero2 > numero1)
    {
        printf("%.2f < %.2f <  %.2f",numero1,numero2,numero3);
    }
    else 
    {
        printf("entrada invalida");
    }
}






