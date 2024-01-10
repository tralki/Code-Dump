#include<stdio.h>
int i;
char m[50];
char l[50];
int a;
int b;
int c;

int strLen(char *l){
    a=0;
    for(i=0 ; l[i]!='\0'; i++){
            a++;
        }
    return a;
}

int vowelCount(char *l){
    a=0;
    for(i=0 ; l[i]!='\0' ; i++){
        if (l[i] == 'a' | l[i] == 'e' | l[i] == 'i' | l[i] == 'o' | l[i] == 'u'){
            a++;
        }
    }
    return a;
}

int strSet(char *l){
    a=0;
    for(i=0 ; l[i]!='\0' ; i++){
        l[i] = 'x';
    }
    return l;
}

int consonanteCount(char *l){
    a=0;
    for(i=0 ; l[i]!='\0' ; i++){
        if(l[i] == 'b'|l[i] =='c'|l[i] =='d'|l[i] =='f'|l[i] =='g'|l[i] =='h'|l[i] =='j'|l[i] =='k'|l[i] =='l'|l[i] =='m'|l[i] =='n'|l[i] =='p'|l[i] =='q'|l[i] =='r'|l[i] =='s'|l[i] =='t'|l[i] =='v'|l[i] =='w'|l[i] =='x'|l[i] =='y'|l[i] =='z'){
            a++;
        }
    }
    return a;
}

int strReverse(char *l, int b){
    a=1;
    for(i=0 ; i < b ; i++){
        m[i] = l[b - a]; 
        a++;
    }
    return m;
}

int isPalindrome(char *l, int b){
    a=1;
    c=0;
    for(i=0 ; i < b ; i++){
        if(l[i] == l[b - a]){
            c++;
        } 
        a++;
    }
    if(b == c){
        return "sera";
    }
    else{
        return "nao sera";
    }
    
}
