/# Ejemplo 6 #/
int z;

int a(void){
    int z; %esta variable ya existe
    z ::= 2;
    z ::= 3 + 5;
}

%esta funcion ya existe
int a(void){
    if(2 LT 3){
        int z; %esta variable ya existe
        z ::= 4;
    }
}

void main(void){
    if( z LT 100)
        return;
}