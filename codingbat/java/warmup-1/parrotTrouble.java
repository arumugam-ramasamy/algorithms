public boolean parrotTrouble(boolean talking, int hour) {
    if ((hour < 7 || hour > 20) && talking == true) {
	return true ;
    }
    return false ;
  
}
