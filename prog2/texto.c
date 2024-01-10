#include<stdio.h>

int strLen(char *l){
    for(i=0 ; l[i]!='\0'; i++){
            a++;
        }
    return a;
}

int vowelCount(char *l){
    for(i=0 ; l[i]!='\0' ; i++){
        if (l[i] == 'a' | l[i] == 'e' | l[i] == 'i' | l[i] == 'o' | l[i] == 'u'){
            b++;
        }
    }
    return b;
}

int strSet(char *l){
    for(i=0 ; l[i]!='\0' ; i++){
        l[i] = 'x';
    }
    return l;
}

int consonanteCount(char *l){
    for(i=0 ; l[i]!='\0' ; i++){
        if(l[i] == 'b'|l[i] =='c'|l[i] =='d'|l[i] =='f'|l[i] =='g'|l[i] =='h'|l[i] =='i'|l[i] =='j'|l[i] =='k'|l[i] =='l'|l[i] =='m'|l[i] =='n'|l[i] =='p'|l[i] =='q'|l[i] =='r'|l[i] =='s'|l[i] =='t'|l[i] =='v'|l[i] =='w'|l[i] =='x'|l[i] =='y'|l[i] =='z'){
            c++;
        }
    }
    return (c);
}
