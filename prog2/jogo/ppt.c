// zerinho um 
// pedra papel tesoura 
// par ou impar 
// jogo do galo

#include<stdio.h>
#include<time.h>
#include<math.h>
#include<stdlib.h>


void zerinho_um();



int main (){
    int es;
    printf("*************************************");
    printf("\nBen vinto ao muntijogos , selecione o jogo que quer jogar\n");
    printf("1: zeriho um   2:par ou impar   3:pedra papael tesoura   4:jogo do galo\n");
    scanf("%d",&es);
    switch(es){
        case(1):
        zerinho_um();
        break;
    }
}


void zerinho_um (){
    int com;
    int com2;
    int num;
    //random
    srand(time(NULL));
    com = rand()%2;
    com2 = rand()%2;
    //codigo de seleção de numero 
    printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    printf("\nEscolha 0 ou 1\n");
    scanf("%d",&num);
    while (num > 2){
        printf("\nnumero invalido, escolha outro");
        scanf("%d",&num);
        break;
    }
    printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    if (num == com == com2 | num == com | num == com2){
        printf("\n*************** Ganhaste *************");
    }
    else if (num != com == com2 | num != com2 == com){
        printf("\n*************** Perdeste *************");
    }
}

void par_impar(){
    int com;
    int num;
    int ver;
    char * ip;
    srand(time(NULL));
    com = rand()%11;
    printf("Escolha Par ou Impar");
    scanf("%s",ip);
    if (ip == "Par" | ip == "par" | ip == "PAR"){
        ver = 1;
    }
    if (ip == "Impar" | ip == "IMPAR" | ip == "impar"){
        ver = 2;
    }
    
}