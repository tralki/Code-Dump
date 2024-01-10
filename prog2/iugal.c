#include<stdio.h>
#include<ctype.h>
int main(){
    char nome[30];
    char nome2[30];
    int i;
    int a;
    int b;
    printf("introduza o seu nome  :");
    scanf("%s", nome);
    printf("introduza outro nome  :");
    scanf("%s", nome2);

    for (i = 0; i<30 ; i++){
        if ( tolower(nome[i]) == tolower(nome2[i])){
            a++;
        }
        else{
            b++;
        }
    }
    if ( b >= 1){
    printf("os nomes não são iguais");
    } 
    else{
        printf("os nomes são iguais");
    }
}
