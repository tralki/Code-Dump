#include <stdio.h>
/*Crie um programa que pede ao utilizador o tamanho do array que deseja, pede todos os elementos desse array,
 e pede um numero Num. O programa deve devolver imprimir no ecra vezes esse numero N aparece no Array.*/
int main(){
    int a;
    printf("\nPorfavor insira o tamanho do array : ");
    scanf("%d",&a);
    int v[a];
    printf("\nAgora insira todos os valores desse array: ");
    int i;
    for (i=0 ; i<a ; i++){
        scanf("%d;",&v[i]);
    }
    int num;
    printf("\nAgora insira um numero que existe no array: ");
    scanf("%d",&num);
    int c = 0;
    for (i=0 ; i<a ; i++){
        if(v[i] == num){
            c++;
        }
    }
    printf("\nExiste %d %d vezes",num,c);
}