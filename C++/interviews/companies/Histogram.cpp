//
// Created by pranav on 7/10/22.
//

#include "Histogram.h"
using namespace  std ;

void Histogram::histostring (string & numberstr) {

    if (validate_str(numberstr) == false)  {
        resultstr.append("Non numeric characeres found ") ;
        resultstr.append(numberstr) ;
        resultstr.append("\n") ;
        return;
    }
    if (valid_limits(numberstr) == -1) {
        resultstr.append(" input limit is  0 - 9 but given ") ;
        resultstr.append(numberstr) ;
        resultstr.append("\n") ;
        return;
    }
        int num = stoi(numberstr) ;
        for (int i = num ; i > STEP_COUNT ; i-= STEP_COUNT)
         {
            resultstr.append(STEP_COUNT, '*') ;
            resultstr.append(" ") ;
        }
        resultstr.append(num%STEP_COUNT, '*') ;
        resultstr.append("\n") ;

}

int Histogram::valid_limits(string &str) {
    int value = stoi(str.c_str()) ;
    if (value < MIN || value > MAX) return -1 ;
    return value ;
}
bool Histogram::validate_str(string & str) {
    for (char ch: str) {
        if (isdigit(ch) == false) return false;
    }
    return true ;
}

string Histogram::histogram () {
    if (numberstr.empty()) return "" ;
    size_t pos = 0;
    std::string token;
    string delimiter = ",";
    while ((pos = numberstr.find(delimiter)) != std::string::npos) {
        token = numberstr.substr(0, pos);
       histostring(token) ;
        numberstr.erase(0, pos + delimiter.length());
    }
    token = numberstr.substr(0, pos);
    histostring(token) ;
    numberstr.erase(0, pos + delimiter.length());

    return  resultstr ;
}

const string &Histogram::getNumberstr() const {
    return numberstr;
}

void Histogram::setNumberstr(const string &numberstr) {
    Histogram::numberstr = numberstr;
    Histogram::resultstr = "" ;
}
