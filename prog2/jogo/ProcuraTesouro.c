//Rafael Sousa Nº25518
//Bruno Roque Nº25391


//bibliotecas 
#include<stdio.h>
#include<time.h>
#include<math.h>
#include<stdlib.h>
//Variaveis
char confirmacao;
int i;
int j;
int x;
int y;
char tabuleiro[60][60];
char player = '&';
int px;
int py;
char tesouro = 'X';
int tx;
int ty;
int media;
float media2;
int t = 1;
int move;

//Funções chamadas para poderem ser lidas pelo main
void srand();
void plataforma();
void start();
void premio();
void movimento();

//Função principal
int main(){
    system("cls");
    printf("\n\n\n\n***************Caca ao tesouro***************\nDeseja comecar? y/n\n");
    scanf("%c",&confirmacao);
    if (confirmacao != 'y'){
        printf("\nhave a nice day");}
    else{
    plataforma();
    start();
    system("cls");
    premio();
    movimento();
}
}

//**************************************************************

//Funções 


//Função que ira pedir ao jogador o tamanho de taboleiro que deseja ter
void plataforma(){
    printf("quantas linhas voce quer que o jogo tenha?\n");
    scanf("%d",&x);
    printf("quantas colunas voce quer que o jogo tenha?\n");
    scanf("%d",&y);
    //este ciclo irá verificar se não foi excedido o limite da matriz
    while (x <= 1 | y<= 1 | x >= 60 | y >= 60){
        printf("\n**Tabuleiro inconsebivel, tente de novo**\n\n");
        printf("quantas linhas voce quer que o jogo tenha?\n");
        scanf("%d",&x);
        printf("quantas colunas voce quer que o jogo tenha?\n");
        scanf("%d",&y);
    }
    system("cls");
    for (i = 0 ; i < x ; i++){
        for (j = 0 ; j < y ; j++){
            tabuleiro[j][i] = 'X';
            printf("%c",tabuleiro[j][i]);
        }
        printf("\n");
    }

}

//Função que irá dar ao jogador a escolha de onde colucar o personagem
void start ()
{
    printf("\n deseja comecar em que posicao? ");
    printf("\nposicao x:");
    scanf("%d",&px);
    printf("posicao y:");
    scanf("%d", &py);
    tabuleiro[px][py] =  player;
    for (i = 0 ; i < x ; i++){
        for (j = 0 ; j < y ; j++){
            printf("%c",tabuleiro[j][i]);
        }
        printf("\n");
    }
    system("cls");

}

//Função que irá randomicamente colocar o premio algures no tabuleiro
void premio ()
{
    srand(time(NULL));
    tx = rand()%x;
    ty = rand()%y;
    tabuleiro[tx][ty] =  tesouro;
}

//Função que cria o plano atravês de um for
void plano(int px,int py){
    for (i = 0 ; i < x ; i++){
            for (j = 0 ; j < y ; j++){
            printf("%c",tabuleiro[j][i]);
            }
            printf("\n");
        }
}
//função que vai tratar do movimento do nosso personagem , assim como dizer a distancia a que se encotra do premio
void movimento()
{
    while (t = 1){
        //verificação da possibilidade do jogador se movimentar indicando o sitio disponivel com '-'
        if (px >= 0 && px < x-1){
            if (tabuleiro[px+1][py] != '~' && tabuleiro[px+1][py] != 'O' ){
                tabuleiro[px+1][py]='-';
        }}
        if (px > 0 && px < x){
            if (tabuleiro[px-1][py] != '~' && tabuleiro[px-1][py] != 'O' ){
                tabuleiro[px-1][py]='-';
        }}
        if (py > 0 && py < y-1){
            if (tabuleiro[px][py-1] != '~' && tabuleiro[px][py-1] != 'O'){
                tabuleiro[px][py-1]='-';
        }}
        if (py >= 0 && py < y){
            if (tabuleiro[px][py+1] != '~' && tabuleiro[px][py+1] != 'O' ){
                tabuleiro[px][py+1]='-';
        }}

        //função para correr o plano
        plano(px , py);

        //assimilação de jogadas passadas e substituição por simbolos que representem um sitio onde passou recentemente '~' e um sitio passado á 2 jogadas a trás 'O'
        switch (move)
        {
            case (1):
                px--;
                tabuleiro[px][py] = 'O';
                px++;
                tabuleiro[px][py] = '~';
                break;
            case (2):
                px++;
                tabuleiro[px][py] = 'O';
                px--;
                tabuleiro[px][py] = '~';
                break;
            case (3):
                py--;
                tabuleiro[px][py] = 'O';
                py++;
                tabuleiro[px][py] = '~';
                break;
            case (4):
                py++;
                tabuleiro[px][py] = 'O';
                py--;
                tabuleiro[px][py] = '~';
                break;
            case (0):
                break;
            default:
                printf("Jogada invalida");
                break;
        }
        
        //distancia entre o jogador e o tesouro
        media = (tx-px)*(tx-px)+(py-ty)*(py-ty);
        media2 = sqrt(media);
        printf("%.2f", media2);
        
        printf("\n");
        
        //verificação da possibilidade de jogada e remoção dos '-' antes colocados
        if (px >= 0 && px < x-1){
        printf("direita : 1 ; ");
        if (tabuleiro[px+1][py] != '~' && tabuleiro[px+1][py] != 'O' ){
        tabuleiro[px+1][py]='X';
        }}

        if (px > 0 && px <= x){
        printf("esquerda : 2 ; ");
        if (tabuleiro[px-1][py] != '~' && tabuleiro[px-1][py] != 'O' ){
        tabuleiro[px-1][py]='X';
        }}

        if (py >=0 && py < y-1){
        printf("baixo : 3 ; ");
        if (tabuleiro[px][py-1] != '~' && tabuleiro[px][py-1] != 'O' ){
        tabuleiro[px][py-1]='X';
        }}

        if (py > 0 && py <= y){  
        printf("cima : 4 ; ");
        if (tabuleiro[px][py+1] != '~' && tabuleiro[px][py+1] != 'O' ){
        tabuleiro[px][py+1]='X';
        }}

        printf("Desistir : 0 ;");

        printf("\nFaca a sua jogada: ");
        scanf("%d",&move);

        
        //precedente a escolha feita anterior mente este codigo fara com que a posição atual do jogador seja '~' e que a que foi dada a ordem de movimento seja '&'
        switch (move)
        {
            case (1):
                tabuleiro[px][py] = '~';
                px++;
                tabuleiro[px][py] = '&';
                break;
            case (2):
                tabuleiro[px][py] = '~';
                px--;
                tabuleiro[px][py] = '&';
                break;
            case (3):
                tabuleiro[px][py] = '~';
                py++;
                tabuleiro[px][py] = '&';
                break;
            case (4):
                tabuleiro[px][py] = '~';
                py--;
                tabuleiro[px][py] = '&';
                break;
            case (0):
                break;
            default:
                printf("Jogada invalida");
                break;
        }


        printf("\n\n\n");
        
        //no caso de encontrar o tesouro 
        if (px == tx && py == ty){
        system("cls");    
            printf("\n\n\n\n\n\n");
            printf("***********Ganhaste o jogo parabens; O teu premio vai ser 2M kidzos***********\n\n\n\n\n");
            t = 0;
            break;
        }

        //no caso de sair do mapa havera um game over 
        if ( px > x-1 | py > y-1 | px < 0 | py < 0){
            system("cls");
            printf("####### Caiste do tabuleiro GAME OVER ######");
            break;
        }

        //no caso de desistencia 
        if (move == 0 ){
        system("cls");
            printf("O tesouro estava nas cordenadas (%d,%d) e continha 2M kidzos",tx,ty);
            t = 0;
            break;
        }
        //nota: isto foi feito com if's pois o swich case não aceita variaveis
        system("cls");
    }
}


