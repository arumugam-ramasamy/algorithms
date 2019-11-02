public boolean stringE(String str) {
    int eCount = 0 ;
  
    for (int i = 0 ; i < str.length() ;  i++) {
	if (str.charAt(i) == 'e') eCount += 1 ;
    }
  
    if (eCount == 1 || eCount == 3) return true ;
    return false ;
  
}
