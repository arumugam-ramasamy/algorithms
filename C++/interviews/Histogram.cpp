//
// Created by pranav on 7/10/22.
//

#include "Histogram.h"
using namespace  std ;

void Histogram::histostring (string & numberstr) {
    for (char ch : numberstr) {
        int num = (int) ch ;
        if (num >= 5) {
            resultstr.append(num, '*') ;
            resultstr.append(" ") ;
            num = num - 5 ;
        }
        resultstr.append(num, '*') ;
        resultstr.append("\n") ;
    }
}
bool Histogram::validate_str(string & str) {
    for (char ch: str) {
        if (isdigit(ch) == false) return false;
    }
    return true ;
}

string Histogram::histogram (string s) {
    if (numberstr.empty()) return "" ;

    size_t pos = 0;
    std::string token;
    string delimiter = ",";
    while ((pos = numberstr.find(delimiter)) != std::string::npos) {
        token = numberstr.substr(0, pos);
        if (validate_str(token) == false) {
            cout << "invalid number and invalid input" << endl ;
            exit(0) ;
        }
       histostring(token) ;
        s.erase(0, pos + delimiter.length());
    }

}
