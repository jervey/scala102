#include <stdio.h>
int pascaltri(int c, int r);

int main(){
    int c, r, result;
    printf ("enter values separate with space: \n");
    scanf ("%i %i", &c, &r);
    result = pascaltri(c, r);
    printf ("%i", result);
}

int pascaltri (int c, int r){
    if (c == r || c == 0){
        return 1;
    }
    return pascaltri(c-1, r-1) + pascaltri(c, r-1);
}