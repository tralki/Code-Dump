#include <stdio.h>
#include <math.h>

void print_matriz(int rows, int columns, int i_rw, int i_cl){

    int x,y;

    for(y = 0; y < rows; y++){ 
        for(x = 0; x < columns; x++){
            if(i_rw == y && x == i_cl){
                printf("&  ");
            }
            else{
                printf("X  ");
            }
        }
        printf("\n");
    }
}


void move_player(int i_rw, int i_cl, int rows, int columns)
{

    int nextpos, y, x;

    printf("\nQuer ir para onde?\n");
    printf("\n0 - Desistir\t");
    printf("1 - Norte\t");
    printf("2 - Sul\t\t");
    printf("3 - Este\t");
    printf("4 - Oeste\t\n");

    scanf("%d", &nextpos);

    switch (nextpos)
    {
    case 0:
        printf("Obrigado por jogar");
        break;

    case 1:
            i_rw = i_rw +1;
            print_matriz(rows, columns, i_rw, i_cl);
        break;

    case 2:

        printf("&  ", (i_rw, i_cl + 1));
        if (i_rw - 1 == i_rw - 2 || i_cl - 1 == i_cl - 2)
        {
            printf("-  ");
        }

        break;

    case 3:

        printf("&  ", (i_rw - 1, i_cl));
        if (i_rw - 1 == i_rw - 2 || i_cl - 1 == i_cl - 2)
        {
            printf("-  ");
        }

        break;

    case 4:

        printf("&  ", (i_rw + 1, i_cl));
        if (i_rw - 1 == i_rw - 2 || i_cl - 1 == i_cl - 2)
        {
            printf("-  ");
        }

        break;
    }
}