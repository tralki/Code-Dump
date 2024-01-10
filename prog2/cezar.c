#include<stdio.h>

int c;
char a;
char d;

int cezar(char a, int c){
int f;
    switch (a)
    {
    case ('a'):
    f = c + 1;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('b'):
    f = c + 2;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('c'):
    f = c + 3;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('d'):
    f = c + 4;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('e'):
    f = c + 5;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('f'):
    f = c + 6;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('g'):
    f = c + 7;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('h'):
    f = c + 8;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('i'):
    f = c + 9;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('j'):
    f = c + 10;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('k'):
    f = c + 11;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('l'):
    f = c + 12;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('m'):
    f = c + 13;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('n'):
    f = c + 14;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('o'):
    f = c + 15;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('p'):
    f = c + 16;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('q'):
    f = c + 17;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('r'):
    f = c + 18;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('s'):
    f = c + 19;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('t'):
    f = c + 20;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('u'):
    f = c + 21;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('v'):
    f = c + 22;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('w'):
    f = c + 23;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('x'):
    f = c + 24;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('y'):
    f = c + 25;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    case ('z'):
    f = c + 26;
    if( f > 26 ){
        f = f - 26;
    }
        break;
    default:
        break;
    }

    switch (f)
    {
    case (1):
    d = 'a';
        break;
    case (2):
    d = 'b';
        break;
    case (3):
    d = 'c';
        break;
    case (4):
    d = 'd';
        break;
    case (5):
    d = 'e';
        break;
    case (6):
    d = 'f';
        break;
    case (7):
    d = 'g';
        break;
    case (8):
    d = 'h';
        break;
    case (9):
    d = 'i';
        break;
    case (10):
    d = 'j';
        break;
    case (11):
    d = 'k';
        break;
    case (12):
    d = 'l';
        break;
    case (13):
    d = 'm';
        break;
    case (14):
    d = 'n';
        break;
    case (15):
    d = 'o';
        break;
    case (16):
    d = 'p';
        break;
    case (17):
    d = 'q';
        break;
    case (18):
    d = 'r';
        break;
    case (19):
    d = 's';
        break;
    case (20):
    d = 't';
        break;
    case (21):
    d = 'u';
        break;
    case (22):
    d = 'v';
        break;
    case (23):
    d = 'w';
        break;
    case (24):
    d = 'x';
        break;
    case (25):
    d = 'y';
        break;
    case (26):
    d = 'z';
        break;
    default:
        break;
    }
    
    
    return d;
}

int main(){
int i;
char l[50];
printf("Porfavor escreva uma palavra ");
scanf ("%s", l);
printf("profavor insira a distancia ");
scanf ("%d", &c);
for(i = 0; i < 50;i++){
    a = l[i];
    if (a == '\0'){
        break;
    }
    else{
    l[i] = cezar(a , c);
}
}
printf("%s", l);



}