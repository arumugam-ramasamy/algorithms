#include <iostream>
#include <string>
#include <sstream>
#include "Histogram.h"

using  namespace std ;



int main(int argc, char *argv[] ) {
    string s = "0,4,2,4,6,7,9,4,6" ;
    Histogram histogram(s) ;
    cout << "----------------------- Input String  -------------------------------" << endl ;
    cout <<   histogram.numberstr << endl ;
    cout << "----------------------- Answer -------------------------------" << endl ;
    cout <<  histogram.histogram()  << endl ;
    histogram.setNumberstr("00,99,9") ;
    cout << "----------------------- Input String  -------------------------------" << endl ;
    cout <<  histogram.numberstr << endl  ;
    cout << "----------------------- Answer -------------------------------" << endl ;
    cout << histogram.histogram()  << endl ;
    cout << "----------------------- Input String -------------------------------" << endl ;
    histogram.setNumberstr("0,9,a") ;
    cout <<  histogram.numberstr << endl  ;
    cout << "----------------------- Answer -------------------------------" << endl ;
    cout <<  histogram.histogram()  << endl ;
    return 0;
}

