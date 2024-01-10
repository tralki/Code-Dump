#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "flib.h"

int main()
{
    int rows, columns, i_rw, i_cl;
    //system("cls") // limpa a consola
    char begin; // variável de decisão
    float **matriz;
    // introdução do jogo
    printf("\n\n\t\tBem vindo ao jogo Caca ao Tesouro!!\n\n");
    printf("Regras:\n\n - Escolher o numero de linhas e colunas.\n - Escolher linha e a coluna de partida.\n - Introduzir um dos respetivos numeros disponiveis(0-4) interagir.\n");
    printf("\n\nLegenda:\n - '&': onde esta\n - '-': jogadas possiveis\n - '~': locais onde esteve.\n\n");
    printf("\tPretendes iniciar o jogo? Responde com [y] ou [n].\n");

    scanf("%s", &begin); // o utilizador define se o jogo começa ou não


    if (begin != 'n' && begin != 'y' && begin != 'Y' && begin != 'N')// verifica se o valor introduzido é diferente de y e n.
    { 
        printf("Valor invalido, recomeca o jogo.");
    }
    else if (begin == 'n' || begin == 'N')// cancela o jogo
    { 
        printf("Obrigado por nem sequer ter tentado jogar. :(");
    }
    else if (begin == 'y' || begin == 'Y'){ // começa o jogo
    
    printf("\n\t----- Jogo Iniciado -----\n");
    printf("\nQuantas linhas tera o tabuleiro?\n");
    scanf("%d", &rows); // indicar o número de linhas a reservar na memória
    printf("Quantas colunas tera o tabuleiro?\n");
    scanf("%d", &columns); // indicar o número de colunas a reservar na memória
    printf("Qual a linha inicial?\n");  
    scanf("%d", &i_rw); // indicar qual será a linha de partida
    printf("Qual a coluna inicial?\n"); 
    scanf("%d", &i_cl); // indicar qual será a coluna de partida

    print_matriz( rows, columns, i_rw, i_cl);
    move_player( rows, columns, i_rw, i_cl);
    }
}