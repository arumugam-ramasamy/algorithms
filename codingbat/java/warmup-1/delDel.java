public String delDel(String str) {
    int ind = 0 ;
    ind = str.indexOf("del", ind) ;
    if (ind == 1 ) {
	str = str.replace("del", "") ;
	return str ;
    }
    else {
	return str ;
    }
  
}
