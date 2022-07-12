//
// Created by pranav on 7/10/22.
//

#ifndef INTERVIEWS_HISTOGRAM_H
#define INTERVIEWS_HISTOGRAM_H

#include <string>
#include <iostream>

using namespace  std ;

class Histogram {
public :
    string numberstr ;
    string resultstr ;

    Histogram(string s) {
        numberstr = s ;
        resultstr = "" ;
    }

    bool validate_str (string &) ;
    void histostring(string &) ;
    string histogram (string s) ;


};


#endif //INTERVIEWS_HISTOGRAM_H
