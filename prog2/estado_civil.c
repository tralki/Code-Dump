#include <stdio.h>

int main()
{
    char ecivil;
    printf("dependendo do seu estado civil coloque um dos seguintes caracteres S-solteiro C-casado D-divurciado ou V-viuvo :");
    scanf("%c",&ecivil);
    ecivil = toupper(ecivil); 

    if (ecivil == 'S')
    {
    printf("\nestado civil = solteiro\n");
    }
    else if (ecivil == 'C')
    {
    printf("\nestado civil = casado\n");
    }
    else if (ecivil == 'D')
    {
    printf("\nestado civil = divurciado\n");
    }
    else if (ecivil == 'V')
    {
    printf("\nestado civil = viuvo\n");
    }
    else
    {
    printf("\nERRO\n");
    }

};