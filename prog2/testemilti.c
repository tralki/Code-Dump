#include <stdio.h>
int main() {
int i;
int b;
printf("insira um valor pequeno: ");
scanf("%d",&i);
printf("insira um valor superior ao anterior");
scanf("%d",&b);
for (i; i <= b ; i++){
    if (i % 2 != 0){
        printf("%d\n",i);
    }
}
}
