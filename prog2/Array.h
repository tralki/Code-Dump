#include<stdio.h>
#include<time.h>
#include<math.h>

int i;
int dim;
int v1[10];
int v2[10];
int vf[10];
int a;
int b;
int j;
int matriz[100][100];
int tranposta[100][100];

int* getArray(int dim){
    printf("\nOs valores do primeiro array sao:");
    for (i = 0 ; i < dim ; i++){
        scanf("%d",&v1[i]);
    }
    printf("\nOs valores do segundo array sao: ");
    for (i = 0 ; i < dim ; i++){
        scanf("%d",&v2[i]);
    }
    return v1,v2;
}


void printArray(int* v1,int* v2,int dim){
    printf("\n\nO primeiro array tem os valores {");
    for (i = 0 ; i < dim ; i++){
        printf("%d;",v1[i]);
    }
    printf("}\nO segundo array tem os valores {");
    for (i = 0 ; i < dim ; i++){
        printf("%d;",v2[i]);
    }
    printf("}");
}

void somaArray(int* v1,int* v2,int dim){
    for(i = 0 ; i < dim ; i++){
        vf[i] = v1[i] + v2[i];
    }
    printf("\nA soma dos arrays e = {");
    for (i = 0 ; i < dim ; i++){
        printf("%d;",vf[i]);
    }
    printf("}");
}

void** getMatriz(int a, int b){
    srand(time(NULL));
    printf("\nA matriz =\n");
    for(i = 0 ; i < a ; i++){
        for(j = 0 ; j < b ; j++){
            matriz[i][j] = rand()%10;
            printf("%d",matriz[i][j]);
            tranposta[j][i] = matriz[i][j];
        }
        printf("\n");
    }
    printf("\nA transposta da matriz =\n");
    for(i = 0 ; i < b ; i++){
        for(j = 0 ; j < a ; j++){
            printf("%d",tranposta[i][j]);
        }
        printf("\n");
    }
}