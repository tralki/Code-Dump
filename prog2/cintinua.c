#include <stdio.h>
int main() {
    int numero;
    int total = 0;
    int i =0;
    int media;
    while (1){
        printf("entroduza um numero: ");
        scanf("%d", &numero);

        if (numero < 0)
        {
            continue; 
        } 
        else if (numero > 0){
            total = total + numero;
            i++;
        }
        else {
            break;
        }
    }
    media = total / i;
    printf("\nA media é igual a %d", media);
}
