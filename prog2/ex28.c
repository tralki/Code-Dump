#include <stdio.h>
#include <stdlib.h>
#include <math.h>



struct ponto
{
    int x;
    int y;
};

int distancia1(int x1,int y1,int x2,int y2){
    int dis;
    int disf;
    dis = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
    disf = sqrt(dis);
    return disf;
}

int distancia(struct ponto p1,struct ponto p2){
    int dis;
    int disf;
    dis = (p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);
    disf = sqrt(dis);
    return disf;
}

struct ponto leitura2(){
    struct ponto p;
    printf("introduza as cordenadas do ponto");
    scanf("%d",&p.x);
    scanf("%d",&p.y);
    return p;
}

void leitura(){
    struct ponto p1,p2;
    printf("introduza as cordenadas do ponto");
    scanf("%d",&p1.x);
    scanf("%d",&p1.y);
    printf("introduza as cordenadas do outro ponto");
    scanf("%d",&p2.x);
    scanf("%d",&p2.y);
    printf("A distancia entre os 2 pontos e = %d",distancia(p1,p2));
}

int main(){
    struct ponto p1,p2;
    p1 = leitura2();
    p2 = leitura2();
    printf("A distancia entre os 2 pontos e = %d",distancia(p1,p2));
}