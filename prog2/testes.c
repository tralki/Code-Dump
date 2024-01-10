#include<stdio.h>
#include<time.h>
#include<math.h>
#include<stdlib.h>
#include<mem.h>

struct youtube 
{
    char * youtube;
    int inscritos;
};

int i, *pi = &i;
char yo , *pyo = &yo;


int main (){
    int* a = (int* )malloc(sizeof(int));
    char* b = (char* )malloc(sizeof(char));
    struct youtube y1,y2,y3,y4;
    i = 100;
    yo = '&';
    y1.inscritos = i;
    y1.youtube = yo;
    printf("%d , %c \n",y1.inscritos , y1.youtube);
    *pi = 299;
    *pyo = '$';
    y2.inscritos = i;
    y2.youtube = yo;
    printf("%d , %c ",y2.inscritos , y2.youtube);
    *a = 6;
    *b = 'B';
    y3.inscritos = *a;
    y3.youtube = *b;
    printf("\n%d , %c ",y3.inscritos , y3.youtube); 
    free(a);
    free(b);
}
