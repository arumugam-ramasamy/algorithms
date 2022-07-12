//
// Created by pranav on 7/10/22.
//

#include <string>
#include <iostream>

using namespace std ;

bool isNumber(const string& str)
{
    for (char const &c : str) {
        if (std::isdigit(c) == 0) return false;
    }
    return true;
}

string histostring (string linestr) {
    string histstr = "" ;
    if (isNumber(linestr)) {
        int num = stoi(linestr);
        histstr.append(num, '*') ;
        histstr.append("\n") ;
        return  histstr ;
    }
    return histstr ;

}

string histogram (string s) {
    if (s.empty()) return "" ;

    size_t pos = 0;
    std::string token;
    string delimiter = ",";
    string histogramstr = "" ;
    while ((pos = s.find(delimiter)) != std::string::npos) {
        token = s.substr(0, pos);
        //std::cout << token << std::endl;
        if (isNumber(token) == false) {
            cout << "invalid number" << endl ;
        }
        else
            histogramstr.append(histostring(token)) ;
        s.erase(0, pos + delimiter.length());
    }
    if (isNumber(s) == false){
        cout << "invalid number" << endl ;
    }
    std::cout << histogramstr << std::endl;
    return histogramstr;
}


