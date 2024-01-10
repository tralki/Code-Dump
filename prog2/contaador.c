#include <stdio.h>


int main ()
{
 int total = 0 ;
 int contador = 1;
 int valor;
 int media;
 while (contador <= 10)
 {
    scanf("%d",&valor);
    total = total + valor;
    contador = contador + 1;
 }

 media = total / 10;
 printf("media = %d \ntotal = %d",media,total);
}