#include <stdio.h>

int main(){

int v[5] = {1,2,3,4,5};
int i;
for (i=0 ; i<5 ; i++){
    if (v[i] % 2){
        printf("%d",v[i]);
    }
}
}