#include <stdio.h>
#include <math.h>

int main() {
    int i;
    int v[6] = {9,7,4,1,2,4};
    double a;
    double b;
    for ( i =0 ; i<6 ; i++){
        a = v[i] * v[i];
        b=b+a ;
    }
    printf("A raiz do vetor v = %lf\n", sqrt(b));
}