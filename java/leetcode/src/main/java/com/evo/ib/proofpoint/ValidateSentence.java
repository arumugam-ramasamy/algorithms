//For the purposes of this problem, a "valid" sentence is defined as:
//        String starts with a capital letter
//        String has an even number of quotation marks ("\"")
//        String ends with a period character "."
//        String has no period characters other than the last character
//        Numbers below 13 are spelled out ("one", "two, "three", etc…)
//
//        Here are some examples:
//
//        Valid sentences:
//        The quick brown fox said "hello Mr lazy dog".
//        The quick brown fox said hello Mr lazy dog.
//        One lazy dog is too few, one is too many.
//        One lazy dog is too few, thirteen is too many.
//
//        Invalid sentences
//        The quick brown fox said "hello Mr. lazy dog".
//        the quick brown fox said "hello Mr lazy dog".
//        "The quick brown fox said "hello Mr lazy dog."
//        One lazy dog is too few, 12 is too to many.


public class ValidateSentence {
    public static void main(String[] args) {
        System.out.println("hello, world");
    }
    
    // extra condition: check for valid "(" ")"
    
    public static boolean isValidSentence(String sentence) {
        if (sentence == null) return false ;
        sentence = sentence.trim() ;
        int len  = sentence.length() ;
        if (len <= 1) return false ;
        if (!Character.isUpperCase(sentence.charAt(0))) return false ;
        if (sentence.charAt(len-1) != '.') return false ;
        
        int count = 0 ; 
        
        //sentence = StringUtils.chop(sentence) ;
        String [] words = sentence.split (" ") ;
        int numwords = words.length ; 
        int quotescount = 0 ;
        //Stack<Character> parens = new Stack<>() ;
        int parenscount = 0 ;
        while (count < numwords) {
            int wordind = 0 ;
            String word = words[count] ;
            word = word.trim() ;
            
            boolean number = true ;
            while (wordind < word.length()) {
                if (word.charAt(wordind) == '"') ++quotescount ;
                if (word.charAt(wordind) == '.') return false ;
                if (number == true && !Character.isDigit(word.charAt(wordind)))
                    number = false ;
                if (word.charAt(wordind) == '(') ++parenscount ;
                if (word.charAt(wordind) == ')') --parenscount ;
                ++wordind ;     
            }
           
            if (number == true) {
                if (Integer.parseInt(word)  < 13) return false ;
            }
            count++ ;
        }
        
        if (parenscount != 0) return false ;
         if ((quotescount % 2) != 0) return false ;
        return true;
    }
}
