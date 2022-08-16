//
// Created by pranav on 7/15/22.
//
#include <stdio.h>
#include <string.h>

char * reversestring (char *str) {
    if (str == NULL) return NULL;
    int len = strlen(str);

    if (len <= 1) return str ;

    for (int i = 0 ; i < len/2 ; i++) {
        char ch = str[i] ;
        str[i] = str[len-1-i] ;
        str[len-i-1] = ch ;
    }
    return str ;
}

char * reversewords(char *str) {

}

int main (int argc, char *argv) {
    char *nullstr = NULL ;
    char single[] = "a" ;
    char multiple[] = "church" ;
    char complex[] = "I live in a house" ;
    fprintf (stdout, "%s\t%s\t%s\n", reversestring(nullptr), reversestring(single), reversestring(multiple)) ;

}

