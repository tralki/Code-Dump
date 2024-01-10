#include <stdio.h>

int main(int argc, char* argv[])
{
float altura;
float cintura;
printf("qual a altura do triangulo ");
scanf("%f" , &altura);
printf("qual o tamanho da base do triangulo ");
scanf("%f" , &cintura);
float area = altura * cintura / 2;
printf("a area do seu triangulo = %.2f",area);
}