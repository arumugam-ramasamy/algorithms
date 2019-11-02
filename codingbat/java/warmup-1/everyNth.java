public String everyNth(String str, int n) {
    String nth = "" ;
    for (int i = 0 ; i < str.length() ; i+= n) {
	nth += str.charAt(i) ;
    }
    return nth ;
}
