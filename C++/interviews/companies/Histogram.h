//
// Created by pranav on 7/10/22.
//

#ifndef INTERVIEWS_HISTOGRAM_H
#define INTERVIEWS_HISTOGRAM_H

#include <string>
#include <iostream>
#include "Constants.h"

using namespace  std ;

class Histogram {
public :
    string numberstr ;
    string resultstr ;

    const string &getNumberstr() const;

    void setNumberstr(const string &numberstr);

    Histogram(string s) {
        numberstr = s ;
        resultstr = "" ;
    }

    bool validate_str (string &) ;
    void histostring(string &) ;
    string histogram () ;
    int valid_limits(string &) ;

};


#endif //INTERVIEWS_HISTOGRAM_H
