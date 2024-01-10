#include <stdio.h>
int main() {
    int  i  = 1;
    int limite;
    printf("introduza um limite: ");
    scanf("%d",&limite);
    while (i <= limite ){
        int a = 1;
        int b = 1;
        while(a<= i){
            b = b * a;
            a++;
        }
        i++;
        printf("%d,",b);
    }

}