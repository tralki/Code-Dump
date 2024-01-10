#include <stdio.h>

int main(int argc, char* argv[])
{
int n1;
int n2;
printf("escolha um numero ");
scanf("%d" , &n1);
printf("escolha outro numero ");
scanf("%d" , &n2);
int soma = n1 + n2;
int sub = n1 - n2;
int div = n1 / n2;
int mult = n1 * n2;
int mod = n1 % n2; 
printf("soma = %d\nsubtracao = %d\ndivisao = %d\nmultiplicacao = %d\nmodulo = %d",soma ,sub ,div ,mult ,mod);
}