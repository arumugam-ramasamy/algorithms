#include <iostream>
#include <string>
#include <sstream>
#include "Histogram.h"

using  namespace std ;



int main(int argc, char *argv[] ) {
    string s = "0,4,2,4,6,7,9,4,6" ;
    Histogram histogram(s) ;
    if(histogram.validate_str() == false) cout << "input contains non numeric chars" << endl ;
    histogram.histostring() ;
    cout << histogram.resultstr << endl  ;
    return 0;
}

