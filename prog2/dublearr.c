#include<stdio.h>
/*Pede Dois arrays ao utilizador de tamanho T (Tambem pedido ao utilizador) 
e devolve um array com o os numeros que existem em ambos os arrays.*/
int main(){
    int a;
    printf("\nEscolha agora o tamanho dos dois arrays do mesmo tamanho: ");
    scanf("%d",&a);
    int v[a];
    int f[a];
    printf("\nAgora escolha os numeros do vetor v: ");
    int i;
    for(i=0;i<a;i++){
        scanf("%d",&v[i]);
    }
    printf("\nAgora escolha os numeros do vetor f: ");
    for(i=0;i<a;i++){
        scanf("%d",&f[i]);
    }
    printf("\nAqui está a fusão entre os 2 arrays: ");
    int bob = 0;
    int h=0;
    int j=0;
    for(i=0;i<a*2;i++){
        if(bob = 0){
            printf("%d",v[h]);
            h++;
            bob = 1;
        }
        else if (bob = 1){
            printf("%d",f[j]);
            j++;
            bob = 0;
        }
    }
}
